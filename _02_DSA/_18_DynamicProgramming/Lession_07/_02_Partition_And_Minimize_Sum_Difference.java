package Lession_07;

import java.util.Arrays;

public class _02_Partition_And_Minimize_Sum_Difference {

    //  * https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1?utm_source=chatgpt.com
    /*
     ============================================================
     Partition and Minimize Sum Difference

     Approach:
     1. Calculate total sum.
     2. Find every possible subset sum.
     3. Difference = |totalSum - 2 * subsetSum|
     4. Return minimum difference.

     DP State:
     dp[index][sum] = minimum difference possible
                      using elements from index onwards.
     ============================================================
     */

    public static void main(String[] args) {

        int[] arr = {3, 9, 7, 3};

        System.out.println("Recursion      : " + recursion(arr));
        System.out.println("Memoization    : " + memoization(arr));
        System.out.println("Tabulation     : " + tabulation(arr));
        System.out.println("Space Optimize : " + spaceOptimization(arr));
    }

    //=========================================================
    // 1. RECURSION
    //=========================================================

    static int recursion(int[] arr) {

        int total = 0;
        for (int x : arr)
            total += x;

        return solveRec(0, 0, total, arr);
    }

    static int solveRec(int index, int sum1, int total, int[] arr) {

        // All elements processed
        if (index == arr.length)
            return Math.abs(total - 2 * sum1);

        // Take current element
        int take = solveRec(index + 1, sum1 + arr[index], total, arr);

        // Don't take current element
        int notTake = solveRec(index + 1, sum1, total, arr);

        return Math.min(take, notTake);
    }

    //=========================================================
    // 2. MEMOIZATION
    //=========================================================

    static int memoization(int[] arr) {

        int total = 0;
        for (int x : arr)
            total += x;

        Integer[][] dp = new Integer[arr.length][total + 1];

        return solveMemo(0, 0, total, arr, dp);
    }

    static int solveMemo(int index, int sum1, int total,
                         int[] arr, Integer[][] dp) {

        // Base case
        if (index == arr.length)
            return Math.abs(total - 2 * sum1);

        // Already solved
        if (dp[index][sum1] != null)
            return dp[index][sum1];

        // Take
        int take = solveMemo(index + 1,
                sum1 + arr[index],
                total,
                arr,
                dp);

        // Not Take
        int notTake = solveMemo(index + 1,
                sum1,
                total,
                arr,
                dp);

        return dp[index][sum1] = Math.min(take, notTake);
    }

    //=========================================================
    // 3. TABULATION
    //=========================================================

    static int tabulation(int[] arr) {

        int n = arr.length;

        int total = 0;
        for (int x : arr)
            total += x;

        boolean[][] dp = new boolean[n + 1][total + 1];

        // Sum 0 always possible
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {

            for (int sum = 0; sum <= total; sum++) {

                // Not take
                dp[i][sum] = dp[i - 1][sum];

                // Take
                if (sum >= arr[i - 1])
                    dp[i][sum] |= dp[i - 1][sum - arr[i - 1]];
            }
        }

        int ans = Integer.MAX_VALUE;

        // Check every achievable subset sum
        for (int s = 0; s <= total; s++) {

            if (dp[n][s]) {

                ans = Math.min(ans,
                        Math.abs(total - 2 * s));
            }
        }

        return ans;
    }

    //=========================================================
    // 4. SPACE OPTIMIZATION
    //=========================================================

    static int spaceOptimization(int[] arr) {

        int total = 0;
        for (int x : arr)
            total += x;

        boolean[] prev = new boolean[total + 1];

        // Sum 0 possible
        prev[0] = true;

        for (int num : arr) {

            boolean[] curr = Arrays.copyOf(prev, total + 1);

            for (int sum = num; sum <= total; sum++) {

                curr[sum] |= prev[sum - num];
            }

            prev = curr;
        }

        int ans = Integer.MAX_VALUE;

        for (int s = 0; s <= total; s++) {

            if (prev[s]) {

                ans = Math.min(ans,
                        Math.abs(total - 2 * s));
            }
        }

        return ans;
    }
}