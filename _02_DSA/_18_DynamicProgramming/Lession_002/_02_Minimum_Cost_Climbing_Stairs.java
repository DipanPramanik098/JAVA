package Lession_002;

import java.util.Arrays;

public class _02_Minimum_Cost_Climbing_Stairs {

    // * LeetCode 746
    // * https://leetcode.com/problems/min-cost-climbing-stairs/description/

    public static void main(String[] args) {

        int[] cost = {10, 15, 20};

        System.out.println("Top Down DP      : " + minCostTopDown(cost));
        System.out.println("Bottom Up DP     : " + minCostBottomUp(cost));
        System.out.println("Space Optimized  : " + minCostSpaceOptimized(cost));
    }

    // ============================================================
    // Top Down DP (Memoization)
    // Time  : O(n)
    // Space : O(n)
    // ============================================================

    static int minCostTopDown(int[] cost) {

        int n = cost.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, cost, dp);
    }

    static int solve(int i, int[] cost, int[] dp) {

        // Base case
        if (i <= 1) return 0;

        // Already computed
        if (dp[i] != -1) return dp[i];

        // Store answer
        return dp[i] = Math.min(
                solve(i - 1, cost, dp) + cost[i - 1],
                solve(i - 2, cost, dp) + cost[i - 2]
        );
    }

    // ============================================================
    // Bottom Up DP (Tabulation)
    // Time  : O(n)
    // Space : O(n)
    // ============================================================

    static int minCostBottomUp(int[] cost) {

        int n = cost.length;

        // dp[i] = Min cost to reach ith step
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

        // Fill DP table
        for (int i = 2; i <= n; i++) {

            dp[i] = Math.min(
                    dp[i - 1] + cost[i - 1],
                    dp[i - 2] + cost[i - 2]
            );
        }

        return dp[n];
    }

    // ============================================================
    // Space Optimized DP
    // Time  : O(n)
    // Space : O(1)
    // ============================================================

    static int minCostSpaceOptimized(int[] cost) {

        int n = cost.length;

        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        // Build answer
        for (int i = 2; i <= n; i++) {

            int curr = Math.min(
                    prev1 + cost[i - 1],
                    prev2 + cost[i - 2]
            );

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}