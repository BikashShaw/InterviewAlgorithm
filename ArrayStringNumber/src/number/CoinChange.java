package number;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int coins1[] = {1, 2, 5};
        int amount1 = 11;

        System.out.println(coinChange.coinChange(coins1, amount1));

        int coins2[] = {2};
        int amount2 = 3;

        System.out.println(coinChange.coinChange(coins2, amount2));

        int coins3[] = {2, 5, 10, 1};
        int amount3 = 27;

        System.out.println(coinChange.coinChange(coins3, amount3));

        int coins4[] = {186,419,83,408};
        int amount4 = 6249;

        System.out.println(coinChange.coinChange(coins4, amount4));
    }

    public int coinChange(int[] coins, int amount) {
        int coinNeeded = 0;
        while (amount != 0) {
            int maxDenomination = findMaxDenomination(amount, coins);
            if (maxDenomination > 0) {
                amount -= maxDenomination;
                coinNeeded++;
            } else {
                coinNeeded = -1;
                break;
            }
        }

        return coinNeeded;

    }

    private int findMaxDenomination(int amount, int[] coins) {
        int maxDenomination = -1;

        for (int coin : coins) {
            if (amount >= coin && coin > maxDenomination) {
                maxDenomination = coin;
            }
        }
        return maxDenomination;
    }
}
