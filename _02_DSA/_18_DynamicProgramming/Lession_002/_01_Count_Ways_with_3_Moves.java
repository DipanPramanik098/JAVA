package Lession_002;

import java.util.Arrays;

public class _01_Count_Ways_with_3_Moves {

    // * GFG - Count Number of Hops
    // * https://www.geeksforgeeks.org/problems/count-number-of-hops-1587115620/1

    public static void main(String[] args) {

        int n = 5;

        System.out.println("Recursive       = " + recursive(n));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Top Down        = " + topDown(n, dp));

        System.out.println("Bottom Up       = " + bottomUp(n));

        System.out.println("Space Optimized = " + spaceOptimized(n));
    }

    // -------------------------------------------------------
    // 1. Recursive
    // TC : O(3^N)
    // SC : O(N)
    // -------------------------------------------------------
    static int recursive(int n) {

        if (n == 0)
            return 1;

        if (n < 0)
            return 0;

        return recursive(n - 1)
                + recursive(n - 2)
                + recursive(n - 3);
    }

    // -------------------------------------------------------
    // 2. Top Down DP (Memoization)
    // TC : O(N)
    // SC : O(N) + O(N)
    // -------------------------------------------------------
    static int topDown(int n, int[] dp) {

        if (n == 0)
            return 1;

        if (n < 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = topDown(n - 1, dp)
                + topDown(n - 2, dp)
                + topDown(n - 3, dp);
    }

    // -------------------------------------------------------
    // 3. Bottom Up DP (Tabulation)
    // TC : O(N)
    // SC : O(N)
    // -------------------------------------------------------
    static int bottomUp(int n) {

        if (n == 0)
            return 1;

        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {

            dp[i] += dp[i - 1];

            if (i >= 2)
                dp[i] += dp[i - 2];

            if (i >= 3)
                dp[i] += dp[i - 3];
        }

        return dp[n];
    }

    // -------------------------------------------------------
    // 4. Space Optimized DP
    // TC : O(N)
    // SC : O(1)
    // -------------------------------------------------------
    static int spaceOptimized(int n) {

        if (n == 0)
            return 1;

        if (n == 1)
            return 1;

        if (n == 2)
            return 2;

        if (n == 3)
            return 4;

        int[] dp = new int[4];

        dp[0] = 1; // dp[0]
        dp[1] = 1; // dp[1]
        dp[2] = 2; // dp[2]
        dp[3] = 4; // dp[3]

        for (int i = 4; i <= n; i++) {

            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[3];
            dp[3] = dp[0] + dp[1] + dp[2];
        }

        return dp[3];
    }
}