package Lession_003;

import java.util.Arrays;

public class _01_House_Robber {

    // LeetCode 198
    // * https://leetcode.com/problems/house-robber/description/

    public static void main(String[] args) {

        int[] nums = {2, 7, 9, 3, 1};

        System.out.println("Top Down      : " + robTopDown(nums));
        System.out.println("Bottom Up     : " + robBottomUp(nums));
        System.out.println("Space Opti    : " + robSpaceOptimized(nums));
    }

    // ==========================================================
    // Top Down (Memoization)
    // TC -> O(n)
    // SC -> O(n) + O(n) recursion
    // ==========================================================

    static int solve(int[] nums, int n, int[] dp) {

        // Base cases
        if (n == 0) return nums[0];
        if (n == 1) return Math.max(nums[0], nums[1]);

        // Already computed
        if (dp[n] != -1) return dp[n];

        // Pick vs Skip
        return dp[n] = Math.max(
                nums[n] + solve(nums, n - 2, dp),
                solve(nums, n - 1, dp)
        );
    }

    static int robTopDown(int[] nums) {

        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(nums, nums.length - 1, dp);
    }

    // ==========================================================
    // Bottom Up (Tabulation)
    // TC -> O(n)
    // SC -> O(n)
    // ==========================================================

    static int robBottomUp(int[] nums) {

        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Build answer
        for (int i = 2; i <= nums.length - 1; i++) {

            dp[i] = Math.max(
                    nums[i] + dp[i - 2],
                    dp[i - 1]
            );
        }

        return dp[nums.length - 1];
    }

    // ==========================================================
    // Space Optimized
    // TC -> O(n)
    // SC -> O(1)
    // ==========================================================

    static int robSpaceOptimized(int[] nums) {

        if (nums.length == 1) return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        // Compute iteratively
        for (int i = 2; i <= nums.length - 1; i++) {

            int curr = Math.max(
                    nums[i] + prev2,
                    prev1
            );

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}