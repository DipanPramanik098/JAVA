package Lession_07;

import java.util.Arrays;

public class _01_Partition_Equal_Subset_Sum {

    //  * https://www.geeksforgeeks.org/problems/subset-sum-problem2014/1
    /*
     ===========================================================
     Partition Equal Subset Sum

     Approach:
     1. Calculate total sum.
     2. If total sum is odd -> return false.
     3. Else target = totalSum / 2.
     4. Now check if there exists a subset having sum = target.
     ===========================================================
    */

    public static void main(String[] args) {

        int[] arr = {1, 5, 11, 5};

        System.out.println("Recursion      : " + canPartitionRecursion(arr));
        System.out.println("Memoization    : " + canPartitionMemo(arr));
        System.out.println("Tabulation     : " + canPartitionTab(arr));
        System.out.println("Space Optimize : " + canPartitionSpace(arr));
    }

    //===========================================================
    // 1. RECURSION
    //===========================================================

    static boolean canPartitionRecursion(int[] arr) {

        int total = 0;
        for (int x : arr) total += x;

        // Odd sum can never be divided equally
        if ((total & 1) == 1) return false;

        int target = total / 2;

        return solveRec(arr.length - 1, target, arr);
    }

    static boolean solveRec(int i, int target, int[] arr) {

        // Target achieved
        if (target == 0)
            return true;

        // Only first element left
        if (i == 0)
            return arr[0] == target;

        // Don't take current element
        boolean notTake = solveRec(i - 1, target, arr);

        // Take current element
        boolean take = false;
        if (arr[i] <= target)
            take = solveRec(i - 1, target - arr[i], arr);

        return take || notTake;
    }


    //===========================================================
    // 2. MEMOIZATION
    //===========================================================

    static boolean canPartitionMemo(int[] arr) {

        int total = 0;
        for (int x : arr) total += x;

        if ((total & 1) == 1) return false;

        int target = total / 2;

        int[][] dp = new int[arr.length][target + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solveMemo(arr.length - 1, target, arr, dp);
    }

    static boolean solveMemo(int i, int target, int[] arr, int[][] dp) {

        if (target == 0)
            return true;

        if (i == 0)
            return arr[0] == target;

        // Already computed
        if (dp[i][target] != -1)
            return dp[i][target] == 1;

        boolean notTake = solveMemo(i - 1, target, arr, dp);

        boolean take = false;
        if (arr[i] <= target)
            take = solveMemo(i - 1, target - arr[i], arr, dp);

        dp[i][target] = (take || notTake) ? 1 : 0;

        return dp[i][target] == 1;
    }


    //===========================================================
    // 3. TABULATION
    //===========================================================

    static boolean canPartitionTab(int[] arr) {

        int total = 0;
        for (int x : arr) total += x;

        if ((total & 1) == 1) return false;

        int target = total / 2;
        int n = arr.length;

        boolean[][] dp = new boolean[n][target + 1];

        // Sum 0 is always possible
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        // First element
        if (arr[0] <= target)
            dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {

            for (int sum = 1; sum <= target; sum++) {

                boolean notTake = dp[i - 1][sum];

                boolean take = false;
                if (arr[i] <= sum)
                    take = dp[i - 1][sum - arr[i]];

                dp[i][sum] = take || notTake;
            }
        }

        return dp[n - 1][target];
    }


    //===========================================================
    // 4. SPACE OPTIMIZATION
    //===========================================================

    static boolean canPartitionSpace(int[] arr) {

        int total = 0;
        for (int x : arr) total += x;

        if ((total & 1) == 1) return false;

        int target = total / 2;
        int n = arr.length;

        boolean[] prev = new boolean[target + 1];

        prev[0] = true;

        if (arr[0] <= target)
            prev[arr[0]] = true;

        for (int i = 1; i < n; i++) {

            boolean[] curr = new boolean[target + 1];

            curr[0] = true;

            for (int sum = 1; sum <= target; sum++) {

                boolean notTake = prev[sum];

                boolean take = false;
                if (arr[i] <= sum)
                    take = prev[sum - arr[i]];

                curr[sum] = take || notTake;
            }

            prev = curr;
        }

        return prev[target];
    }

}