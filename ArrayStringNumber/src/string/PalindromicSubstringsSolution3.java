package string;

/**
 * Best Solution
 */
public class PalindromicSubstringsSolution3 {

    public static void main(String[] args) {
        PalindromicSubstringsSolution3 palindromicSubstringsSolution3 = new PalindromicSubstringsSolution3();

        System.out.println(palindromicSubstringsSolution3.countSubstrings("aaa"));
        System.out.println(palindromicSubstringsSolution3.countSubstrings("abc"));

        System.out.println(palindromicSubstringsSolution3.countSubstrings("dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg"));
    }

    public int countSubstrings(String str) {
        if (str == null || str.length() < 1) return 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += countPalindromes(str, i, i); //Count even sized
            count += countPalindromes(str, i, i + 1); //Count odd sized
        }
        return count;
    }

    private int countPalindromes(String str, int s, int e) {
        int count = 0;
        while (s >= 0 && e < str.length() && str.charAt(s) == str.charAt(e)) {
            s--;
            e++;
            count++;
        }
        return count;
    }
}
