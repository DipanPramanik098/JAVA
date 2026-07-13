package Lession_06;

import java.util.Arrays;

public class _01_Perfect_Sum_Problem {

    static final int MOD = 1000000007;

    public static void main(String[] args) {

        int[] arr = {5, 2, 3, 10, 6, 8};
        int target = 10;

        System.out.println("Recursion      : " + recursion(arr, target));
        System.out.println("Top Down       : " + topDown(arr, target));
        System.out.println("Bottom Up      : " + bottomUp(arr, target));
        System.out.println("Space Optimized: " + spaceOptimized(arr, target));
    }

    // ==========================================================
    // 1. RECURSION
    // TC : O(2^N)
    // SC : O(N)
    // ==========================================================

    static int recursion(int[] arr, int target) {

        return solve(arr, arr.length - 1, target);
    }

    static int solve(int[] arr, int index, int target) {

        // ---------------- BASE CASE ----------------

        // Only first element is left.
        if (index == 0) {

            // Two subsets are possible:
            // {}
            // {0}
            if (target == 0 && arr[0] == 0)
                return 2;

            // Either
            // don't pick first element
            // OR pick first element
            if (target == 0 || target == arr[0])
                return 1;

            return 0;
        }

        // ---------------- RECURSION ----------------

        // Option 1 : Don't pick current element
        int notPick = solve(arr, index - 1, target);

        // Option 2 : Pick current element
        int pick = 0;

        if (arr[index] <= target)
            pick = solve(arr, index - 1, target - arr[index]);

        return (pick + notPick) % MOD;
    }

    // ==========================================================
    // 2. TOP DOWN (Memoization)
    // TC : O(N * Target)
    // SC : O(N * Target) + O(N)
    // ==========================================================

    static int topDown(int[] arr, int target) {

        int[][] dp = new int[arr.length][target + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return memo(arr, arr.length - 1, target, dp);
    }

    static int memo(int[] arr, int index, int target, int[][] dp) {

        // ---------------- BASE CASE ----------------

        if (index == 0) {

            if (target == 0 && arr[0] == 0)
                return 2;

            if (target == 0 || target == arr[0])
                return 1;

            return 0;
        }

        // Already computed
        if (dp[index][target] != -1)
            return dp[index][target];

        // Don't Pick
        int notPick = memo(arr, index - 1, target, dp);

        // Pick
        int pick = 0;

        if (arr[index] <= target)
            pick = memo(arr, index - 1, target - arr[index], dp);

        return dp[index][target] = (pick + notPick) % MOD;
    }

    // ==========================================================
    // 3. BOTTOM UP (Tabulation)
    // TC : O(N * Target)
    // SC : O(N * Target)
    // ==========================================================

    static int bottomUp(int[] arr, int target) {

        int n = arr.length;

        int[][] dp = new int[n][target + 1];

        // ---------------- BASE CASE ----------------

        // Empty subset
        if (arr[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;

        // First element alone can make target
        if (arr[0] != 0 && arr[0] <= target)
            dp[0][arr[0]] = 1;

        // ---------------- DP ----------------

        for (int index = 1; index < n; index++) {

            for (int sum = 0; sum <= target; sum++) {

                int notPick = dp[index - 1][sum];

                int pick = 0;

                if (arr[index] <= sum)
                    pick = dp[index - 1][sum - arr[index]];

                dp[index][sum] = (pick + notPick) % MOD;
            }
        }

        return dp[n - 1][target];
    }

    // ==========================================================
    // 4. SPACE OPTIMIZATION
    // TC : O(N * Target)
    // SC : O(Target)
    // ==========================================================

    static int spaceOptimized(int[] arr, int target) {

        int n = arr.length;

        int[] prev = new int[target + 1];

        // ---------------- BASE CASE ----------------

        if (arr[0] == 0)
            prev[0] = 2;
        else
            prev[0] = 1;

        if (arr[0] != 0 && arr[0] <= target)
            prev[arr[0]] = 1;

        // ---------------- DP ----------------

        for (int index = 1; index < n; index++) {

            int[] curr = new int[target + 1];

            for (int sum = 0; sum <= target; sum++) {

                int notPick = prev[sum];

                int pick = 0;

                if (arr[index] <= sum)
                    pick = prev[sum - arr[index]];

                curr[sum] = (pick + notPick) % MOD;
            }

            prev = curr;
        }

        return prev[target];
    }
}