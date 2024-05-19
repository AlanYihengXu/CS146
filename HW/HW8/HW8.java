package HW.HW8;

public class HW8 {
    public int longestPalindrome(String s) {
        int[] letters = new int[52];
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'A';
            if (index > 26) {
                index -= 6;
            }
            letters[index]++;
        }
        boolean foundOdd = false;
        for (int i : letters) {
            if (i % 2 == 1) {
                if (!foundOdd) {
                    length += i;
                    foundOdd = true;
                } else {
                    length += i-1;
                }   
            } else {
                length += i;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        HW8 tester = new HW8();
        System.out.println(tester.longestPalindrome("abccccdd"));
        System.out.println(tester.longestPalindrome("speediskey"));
    }
}
