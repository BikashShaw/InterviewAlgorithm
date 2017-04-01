package arrayandstring.dynamicprograming;

import java.util.ArrayList;
import java.util.List;

/**
 * Longest Common Substring
 * Time Complexity: O(n * m)
 * Created by Bikash on 3/23/2017.
 */
public class LongestCommonSubstring {

    public List<String> findSubstring(String str1, String str2) {
        int max = 0;
        List<String> subString = new ArrayList<>();
        int dp[][] = new int[str1.length()][str2.length()];

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                char str1ColChar = str1.charAt(i);
                char str2RowChar = str2.charAt(j);

                if(str1ColChar == str2RowChar) {

                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;

                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }

                    if(dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }
        }

        printMetrix(dp);

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if(dp[i][j] == max) {
                    subString.add(str2.substring(j+1-dp[i][j], j+1));
                }
            }
        }
        return subString;
    }

    private void printMetrix(int[][] dp) {
        for (int[] ints : dp) {
            System.out.println();
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LongestCommonSubstring ins = new LongestCommonSubstring();

        List<String> substringList = ins.findSubstring("ABABBA", "BABA");
        for (String s : substringList) {
            System.out.println(s);
        }

    }
}
