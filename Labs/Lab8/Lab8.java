package Labs.Lab8;

public class Lab8 {
    public int coinChange(int[] coins, int amount) {
        int min = coinChangeRecurse(coins, amount);
        if (min == Integer.MAX_VALUE) min = -1;
        return min;
    }
    private int coinChangeRecurse(int[] coins, int amount) {
        if (amount == 0) return 0;
        int min = Integer.MAX_VALUE;
        for (int i : coins) {
            if (i <= amount) {
                int temp = coinChangeRecurse(coins, amount-i);
                if (temp != Integer.MAX_VALUE) temp++;
                if (temp < min) min = temp;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Lab8 tester = new Lab8();
        int[] coins1 = {1, 2, 5};
        System.out.println(tester.coinChange(coins1, 11)); //3
        int[] coins2 = {2};
        System.out.println(tester.coinChange(coins2, 3)); //-1
        int[] coins3 = {1};
        System.out.println(tester.coinChange(coins3, 0)); //0
        int[] coins4 = {1, 10, 25, 50, 100};
        System.out.println(tester.coinChange(coins4, 40)); //4
        int[] coins5 = {2, 3};
        System.out.println(tester.coinChange(coins5, 11)); //4
    }
}
