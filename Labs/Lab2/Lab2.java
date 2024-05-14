package Labs.Lab2;

public class Lab2 {
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            System.err.println("Input is null");
            return false;
        }
        s = s.toLowerCase().replaceAll("[^a-z]", "");
        t = t.toLowerCase().replaceAll("[^a-z]", "");
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int current = s.charAt(i)-'a';
            letters[current]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int current = t.charAt(i)-'a';
            letters[current]--;
            if (letters[current] < 0) {
                return false;
            }
        }
        for (int i : letters) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("Anagram", "Nag a ram"));
        System.out.println(isAnagram("ABCDE", "DADBC"));
        System.out.println(isAnagram(null, "null"));
    }
}
