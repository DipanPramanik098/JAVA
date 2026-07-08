package Lession_003;

import java.util.Arrays;

public class _02_House_Robber_2 {

    // LeetCode 213
    // * https://leetcode.com/problems/house-robber-ii/

    public static void main(String[] args) {

        int[] nums = {2, 3, 2};

        System.out.println("Top Down      : " + robTopDown(nums));
        System.out.println("Bottom Up     : " + robBottomUp(nums));
        System.out.println("Space Opti    : " + robSpaceOptimized(nums));
    }

    // ==========================================================
    // Top Down (Memoization)
    // TC -> O(n)
    // SC -> O(n) + O(n) recursion
    // ==========================================================

    static int solve(int[] nums, int i, int end, int[] dp) {

        // Crossed range
        if (i > end) return 0;

        // Last house
        if (i == end) return nums[i];

        // Already computed
        if (dp[i] != -1) return dp[i];

        // Pick vs Skip
        return dp[i] = Math.max(
                nums[i] + solve(nums, i + 2, end, dp),
                solve(nums, i + 1, end, dp)
        );
    }

    static int robTopDown(int[] nums) {

        int n = nums.length - 1;

        if (n == 0) return nums[0];
        if (n == 1) return Math.max(nums[0], nums[1]);

        // Case 1 : 0 -> n-1
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1, -1);
        int ans1 = solve(nums, 0, n - 1, dp1);

        // Case 2 : 1 -> n
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2, -1);
        int ans2 = solve(nums, 1, n, dp2);

        return Math.max(ans1, ans2);
    }

    // ==========================================================
    // Bottom Up (Tabulation)
    // TC -> O(n)
    // SC -> O(n)
    // ==========================================================

    static int robBottomUp(int[] nums) {

        int n = nums.length - 1;

        if (n == 0) return nums[0];
        if (n == 1) return Math.max(nums[0], nums[1]);

        // ---------- Case 1 : 0 -> n-1 ----------

        int[] dp1 = new int[nums.length];

        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {

            dp1[i] = Math.max(
                    nums[i] + dp1[i - 2],
                    dp1[i - 1]
            );
        }

        int ans1 = dp1[n - 1];

        // ---------- Case 2 : 1 -> n ----------

        int[] dp2 = new int[nums.length];

        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);

        for (int i = 3; i <= n; i++) {

            dp2[i] = Math.max(
                    nums[i] + dp2[i - 2],
                    dp2[i - 1]
            );
        }

        return Math.max(ans1, dp2[n]);
    }

    // ==========================================================
    // Space Optimized
    // TC -> O(n)
    // SC -> O(1)
    // ==========================================================

    static int robSpaceOptimized(int[] nums) {

        int n = nums.length - 1;

        if (n == 0) return nums[0];
        if (n == 1) return Math.max(nums[0], nums[1]);

        // ---------- Case 1 : 0 -> n-1 ----------

        int p2 = nums[0];
        int p1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {

            int curr = Math.max(
                    nums[i] + p2,
                    p1
            );

            p2 = p1;
            p1 = curr;
        }

        int ans1 = p1;

        // ---------- Case 2 : 1 -> n ----------

        p2 = nums[1];
        p1 = Math.max(nums[1], nums[2]);

        for (int i = 3; i <= n; i++) {

            int curr = Math.max(
                    nums[i] + p2,
                    p1
            );

            p2 = p1;
            p1 = curr;
        }

        return Math.max(ans1, p1);
    }
}