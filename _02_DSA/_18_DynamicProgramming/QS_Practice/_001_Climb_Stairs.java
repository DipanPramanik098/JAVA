package QS_Practice;

import java.util.Arrays;

public class _001_Climb_Stairs {

    // * Leetcode 70
    // * https://leetcode.com/problems/climbing-stairs/

    public static void main(String[] args) {

        int n = 5;

        System.out.println("n = " + n);
        System.out.println();

        System.out.println("Top Down DP      : " + climbStairsTopDown(n));
        System.out.println("Bottom Up DP     : " + climbStairsBottomUp(n));
        System.out.println("Space Optimized  : " + climbStairsSpaceOptimized(n));
    }

    // ============================================================
    // 1. Top Down DP (Memoization)
    // TC : O(n)
    // SC : O(n) + O(n) recursion stack
    // ============================================================

    public static int climbStairsTopDown(int n) {

        // Base Case
        if (n <= 2)
            return n;

        // -1 => Not calculated
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return helper(n, dp);
    }

    private static int helper(int n, int[] dp) {

        // Base Case
        if (n <= 2)
            return n;

        // Return cached answer
        if (dp[n] != -1)
            return dp[n];

        // Store & return
        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);

        return dp[n];
    }

    // ============================================================
    // 2. Bottom Up DP (Tabulation)
    // TC : O(n)
    // SC : O(n)
    // ============================================================

    public static int climbStairsBottomUp(int n) {

        // Base Case
        if (n <= 2)
            return n;

        // dp[i] = Ways to reach ith stair
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        // Build answer from left to right
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // ============================================================
    // 3. Space Optimized DP
    // TC : O(n)
    // SC : O(1)
    // ============================================================

    public static int climbStairsSpaceOptimized(int n) {

        // Base Case
        if (n <= 2)
            return n;

        int prev2 = 1; // f(1)
        int prev1 = 2; // f(2)

        for (int i = 3; i <= n; i++) {

            int curr = prev1 + prev2;

            // Shift window
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}