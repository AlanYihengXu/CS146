package HW.HW1;

public class HW1 {
    public static boolean isPalindrome(String s) {
        String alphanumeric = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < s.length(); i++) {
            if (alphanumeric.indexOf(s.charAt(i)) == -1) {
                s = s.replaceAll(s.substring(i, i+1), "");
            }
        }
        for (int i = 0, j = s.length()-1; i < s.length()/2 && j >= s.length()/2; i++, j--) {
            if (!s.substring(i, i+1).equalsIgnoreCase(s.substring(j, j+1))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String t = "Never odd or even";
        String f = "Not a clue";
        System.out.println(isPalindrome(t));
        System.out.println(isPalindrome(f));
    }
}
