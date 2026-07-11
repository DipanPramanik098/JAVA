package Lession_005;

import java.util.Arrays;

public class _01_Subset_SUM_Problem {
    // * GFG : Subset Sum Problem
    // * https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

    public static void main(String[] args) {

        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = arr.length;

        // Recursion
        System.out.println("Recursion       : " + recursion(n - 1, sum, arr));

        // Top Down DP
        int[][] dp = new int[n][sum + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println("Top Down DP     : " + topDown(n - 1, sum, arr, dp));

        // Bottom Up DP
        System.out.println("Bottom Up DP    : " + bottomUp(arr, sum));

        // Space Optimized DP
        System.out.println("Space Optimized : " + spaceOptimized(arr, sum));
    }

    // -------------------------------------------------------
    // 1. Recursion
    // TC : O(2^N)
    // SC : O(N)
    // -------------------------------------------------------
    public static boolean recursion(int index, int sum, int[] arr) {

        // Target achieved
        if (sum == 0)
            return true;

        // No elements left
        if (index < 0)
            return false;

        // Don't pick current element
        boolean notPick = recursion(index - 1, sum, arr);

        // Pick current element
        boolean pick = false;
        if (arr[index] <= sum)
            pick = recursion(index - 1, sum - arr[index], arr);

        return pick || notPick;
    }

    // -------------------------------------------------------
    // 2. Top Down DP (Memoization)
    // TC : O(N * Sum)
    // SC : O(N * Sum) + O(N)
    // -------------------------------------------------------
    public static boolean topDown(int index, int sum, int[] arr, int[][] dp) {

        // Target achieved
        if (sum == 0)
            return true;

        // No elements left
        if (index < 0)
            return false;

        // Already computed
        if (dp[index][sum] != -1)
            return dp[index][sum] == 1;

        // Don't pick current element
        boolean notPick = topDown(index - 1, sum, arr, dp);

        // Pick current element
        boolean pick = false;
        if (arr[index] <= sum)
            pick = topDown(index - 1, sum - arr[index], arr, dp);

        dp[index][sum] = (pick || notPick) ? 1 : 0;

        return dp[index][sum] == 1;
    }

    // -------------------------------------------------------
    // 3. Bottom Up DP (Tabulation)
    // TC : O(N * Sum)
    // SC : O(N * Sum)
    // -------------------------------------------------------
    public static boolean bottomUp(int[] arr, int sum) {

        int n = arr.length;

        boolean[][] dp = new boolean[n][sum + 1];

        // Sum 0 is always possible
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        // Base case for first element
        if (arr[0] <= sum)
            dp[0][arr[0]] = true;

        // Fill DP table
        for (int index = 1; index < n; index++) {

            for (int target = 1; target <= sum; target++) {

                boolean notPick = dp[index - 1][target];

                boolean pick = false;
                if (arr[index] <= target)
                    pick = dp[index - 1][target - arr[index]];

                dp[index][target] = pick || notPick;
            }
        }

        return dp[n - 1][sum];
    }

    // -------------------------------------------------------
    // 4. Space Optimized DP
    // TC : O(N * Sum)
    // SC : O(Sum)
    // -------------------------------------------------------
    public static boolean spaceOptimized(int[] arr, int sum) {

        int n = arr.length;

        boolean[] prev = new boolean[sum + 1];

        // Sum 0 is always possible
        prev[0] = true;

        // Base case for first element
        if (arr[0] <= sum)
            prev[arr[0]] = true;

        // Process remaining elements
        for (int index = 1; index < n; index++) {

            boolean[] curr = new boolean[sum + 1];
            curr[0] = true;

            for (int target = 1; target <= sum; target++) {

                boolean notPick = prev[target];

                boolean pick = false;
                if (arr[index] <= target)
                    pick = prev[target - arr[index]];

                curr[target] = pick || notPick;
            }

            prev = curr;
        }

        return prev[sum];
    }
}