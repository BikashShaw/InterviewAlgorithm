package number.leetcode;

/**
 * https://leetcode.com/problems/coin-change/description/
 */
public class CoinChange {


    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        CoinChange coinChange = new CoinChange();

        System.out.println(coinChange.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int amnt = 1; amnt <= amount; amnt++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (amnt - coin >= 0 && dp[amnt - coin] != -1) {
                    min = Math.min(min, dp[amnt - coin]);
                }
            }
            if (min == Integer.MAX_VALUE) {
                dp[amnt] = -1;
            } else {
                dp[amnt] = min + 1;
            }
        }
        return dp[amount];
    }
}
