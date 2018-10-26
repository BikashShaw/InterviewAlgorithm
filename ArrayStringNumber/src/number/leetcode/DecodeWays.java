package number.leetcode;

/**
 * Leetcode: https://leetcode.com/problems/decode-ways/description/
 */
public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();

        System.out.println(decodeWays.numDecodings_DP("1212"));

        System.out.println(decodeWays.numDecodings_recursion("1212", 4));

    }

    public int numDecodings_DP(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public int numDecodings_recursion(String s, int k) {
        if(k == 0){
            return 1;
        }
        if (s == null || s.length() == 0) {
            return 0;
        }
        if(s.charAt(0) == '0') {
            return 0;
        }
        int result = numDecodings_recursion(s.substring(1), k - 1);

        if(s.length() > 1) {
            int secondNum = Integer.valueOf(s.substring(0, 2));

            if(secondNum <= 26) {
                result += numDecodings_recursion(s.substring(2), k - 2);
            }
        }
        return result;
    }
}
