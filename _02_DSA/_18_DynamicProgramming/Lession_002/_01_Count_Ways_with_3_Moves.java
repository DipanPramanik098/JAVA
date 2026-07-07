package Lession_002;

public class _01_Count_Ways_with_3_Moves {

    // * GFG - Count Number of Hops
    // * https://www.geeksforgeeks.org/problems/count-number-of-hops-1587115620/1
    // * Space Optimized DP
    // * Time  : O(n)
    // * Space : O(1)

    public static void main(String[] args) {

        int n = 5;

        System.out.println("Number of Ways = " + countWays(n));
    }

    static int countWays(int n) {

        // Base cases
        if (n <= 2) return n;
        if (n == 3) return 4;

        // Last 4 DP states
        int[] dp = new int[4];

        dp[0] = 0; // dp[i-4]
        dp[1] = 1; // dp[1]
        dp[2] = 2; // dp[2]
        dp[3] = 4; // dp[3]

        // Build answer
        for (int i = 4; i <= n; i++) {
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[3];
            dp[3] = dp[0] + dp[1] + dp[2];
        }

        return dp[3];
    }
}