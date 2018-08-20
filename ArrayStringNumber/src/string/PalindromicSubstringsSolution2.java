package string;

public class PalindromicSubstringsSolution2 {

    static int counter = 0;

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings("abc"));

        System.out.println(countSubstrings("dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg"));
    }

    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] visited = new boolean[n][n];
        counter = 0;
        new PalindromicSubstringsSolution2().allSubStrings(s, visited, 0, n);

        return counter;
    }

    private void allSubStrings(String str, boolean[][] visited, int left, int right) {

        if (left >= right) {
            return;
        }

        if (!visited[left][right - 1]) {
            visited[left][right - 1] = true;
            if (isPalindrome(str, left, right)) {
                counter++;
            }
        }
        allSubStrings(str, visited, left, right - 1);
        allSubStrings(str, visited, left + 1, right);
    }


    private boolean isPalindrome(String s, int left, int right) {

        while (left < right){
            if (s.charAt(left) != s.charAt(right - 1)) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
}
