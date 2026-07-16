package Lession_08;

import java.util.Arrays;

public class _01_Coin_Change_2 {

    // https://leetcode.com/problems/coin-change-ii/description/

    // ==========================================================
    // 1. RECURSION
    // Time  : Exponential
    // Space : O(N) recursion stack
    // ==========================================================

    static int recursion(int amount, int[] coins, int n) {

        // If amount becomes 0, one valid combination is found.
        if (amount == 0)
            return 1;

        // No coins left or amount becomes negative.
        if (n == 0 || amount < 0)
            return 0;

        // Take current coin (can take again because unlimited supply)
        int take = recursion(amount - coins[n - 1], coins, n);

        // Skip current coin
        int notTake = recursion(amount, coins, n - 1);

        return take + notTake;
    }

    // ==========================================================
    // 2. MEMOIZATION (Top Down)
    // Time  : O(N * Amount)
    // Space : O(N * Amount) + recursion stack
    // ==========================================================

    static int memo(int amount, int[] coins, int n, int[][] dp) {

        if (amount == 0)
            return 1;

        if (n == 0 || amount < 0)
            return 0;

        if (dp[n - 1][amount] != -1)
            return dp[n - 1][amount];

        int take = memo(amount - coins[n - 1], coins, n, dp);

        int notTake = memo(amount, coins, n - 1, dp);

        return dp[n - 1][amount] = take + notTake;
    }

    // ==========================================================
    // 3. TABULATION (Bottom Up)
    // Time  : O(N * Amount)
    // Space : O(N * Amount)
    // ==========================================================

    static int tabulation(int amount, int[] coins) {

        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        // Amount = 0 -> One way (choose nothing)
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {

            for (int target = 1; target <= amount; target++) {

                // Don't take current coin
                int notTake = dp[i - 1][target];

                // Take current coin
                int take = 0;

                if (coins[i - 1] <= target)
                    take = dp[i][target - coins[i - 1]];

                dp[i][target] = take + notTake;
            }
        }

        return dp[n][amount];
    }

    // ==========================================================
    // 4. SPACE OPTIMIZATION
    // Time  : O(N * Amount)
    // Space : O(Amount)
    // ==========================================================

    static int spaceOptimization(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        // Base Case
        dp[0] = 1;

        for (int coin : coins) {

            for (int target = coin; target <= amount; target++) {

                dp[target] += dp[target - coin];
            }
        }

        return dp[amount];
    }

    // ==========================================================
    // MAIN METHOD
    // ==========================================================

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 5;

        int n = coins.length;

        System.out.println("Coins  : " + Arrays.toString(coins));
        System.out.println("Amount : " + amount);

        System.out.println();

        // ---------------- Recursion ----------------
        System.out.println("Recursion : "
                + recursion(amount, coins, n));

        // ---------------- Memoization ----------------
        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println("Memoization : "
                + memo(amount, coins, n, dp));

        // ---------------- Tabulation ----------------
        System.out.println("Tabulation : "
                + tabulation(amount, coins));

        // ---------------- Space Optimization ----------------
        System.out.println("Space Optimization : "
                + spaceOptimization(amount, coins));
    }
}