package Lession_001;

import java.util.Arrays;

public class _01_Fibonacci {

    static int[] dp = new int[100];

    // ==========================================================
    // TODO --> TOP-DOWN Approach (Memoization)
    // Time  : O(n)
    // Space : O(n) + O(n) recursion stack
    // ==========================================================
    static int fib1(int n) {
        if (n <= 1) return n;

        if (dp[n] != -1) return dp[n];

        dp[n] = fib1(n - 1) + fib1(n - 2);
        return dp[n];
    }

    // ==========================================================
    // TODO --> BOTTOM-UP Approach (Tabulation)
    // Time  : O(n)
    // Space : O(n)
    // ==========================================================
    static int fib2(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];

        // Base Cases
        dp[0] = 0;
        dp[1] = 1;

        // Build answer from smaller subproblems
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // ==========================================================
    // TODO --> Space Optimized DP
    // Time  : O(n)
    // Space : O(1)
    // ==========================================================
    static int fib3(int n) {
        if (n <= 1) return n;

        int prev2 = 0;
        int prev1 = 1;

        // Keep only last two Fibonacci numbers
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {

        // TODO --> Initialize DP array with -1 (Memoization)
        Arrays.fill(dp, -1);

        int n = 5;

        // * TOP-DOWN (Memoization)
        System.out.println("Memoization      -> " + fib1(n));

        // * BOTTOM-UP (Tabulation)
        System.out.println("Tabulation       -> " + fib2(n));

        // * SPACE OPTIMIZED DP
        System.out.println("Space Optimized  -> " + fib3(n));
    }
}