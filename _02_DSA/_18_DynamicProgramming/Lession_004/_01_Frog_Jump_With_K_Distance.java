package Lession_004;

import java.util.Arrays;

public class _01_Frog_Jump_With_K_Distance {

    // * https://www.naukri.com/code360/problems/minimal-cost_8180930

    public static void main(String[] args) {

        int[] height = {10, 40, 30, 10};
        int k = 2;

        int n = height.length;

        System.out.println("Recursive      : " + recursive(n, k, height));
        System.out.println("Top Down DP    : " + topDown(n, k, height));
        System.out.println("Bottom Up DP   : " + bottomUp(n, k, height));
        System.out.println("Space Optimized: " + spaceOptimized(n, k, height));
    }

    // ==========================================================
    // 1. Recursive Solution
    // TC -> O(k^n)
    // SC -> O(n)
    // ==========================================================

    static int minEnergy(int index, int[] height, int k) {

        // Base Case
        if (index == 0)
            return 0;

        int result = Integer.MAX_VALUE;

        // Try all jumps from 1 to k
        for (int jump = 1; jump <= k && jump <= index; jump++) {

            result = Math.min(result,
                    Math.abs(height[index] - height[index - jump])
                            + minEnergy(index - jump, height, k));
        }

        return result;
    }

    static int recursive(int n, int k, int[] height) {
        return minEnergy(n - 1, height, k);
    }

    // ==========================================================
    // 2. Top Down DP (Memoization)
    // TC -> O(N × K)
    // SC -> O(N) + O(N)
    // ==========================================================

    static int minEnergy(int index, int[] height, int k, int[] dp) {

        // Base Case
        if (index == 0)
            return 0;

        // Already calculated
        if (dp[index] != -1)
            return dp[index];

        int result = Integer.MAX_VALUE;

        // Try every possible jump
        for (int jump = 1; jump <= k && jump <= index; jump++) {

            result = Math.min(result,
                    Math.abs(height[index] - height[index - jump])
                            + minEnergy(index - jump, height, k, dp));
        }

        return dp[index] = result;
    }

    static int topDown(int n, int k, int[] height) {

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return minEnergy(n - 1, height, k, dp);
    }

    // ==========================================================
    // 3. Bottom Up DP (Tabulation)
    // TC -> O(N × K)
    // SC -> O(N)
    // ==========================================================

    static int bottomUp(int n, int k, int[] height) {

        if (n == 1)
            return 0;

        int[] dp = new int[n];
        dp[0] = 0;

        // Build answer from left to right
        for (int index = 1; index < n; index++) {

            int result = Integer.MAX_VALUE;

            for (int jump = 1; jump <= k && jump <= index; jump++) {

                result = Math.min(result,
                        Math.abs(height[index] - height[index - jump])
                                + dp[index - jump]);
            }

            dp[index] = result;
        }

        return dp[n - 1];
    }

    // ==========================================================
    // 4. Space Optimized
    // TC -> O(N × K)
    // SC -> O(K)
    // ==========================================================

    static int spaceOptimized(int n, int k, int[] height) {

        if (n == 1)
            return 0;

        // Window size can't exceed n-1
        k = Math.min(k, n - 1);

        int[] dp = new int[k + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;

        // Fill first k states
        for (int index = 1; index <= k && index < n; index++) {

            int result = Integer.MAX_VALUE;

            for (int jump = 1; jump <= k && jump <= index; jump++) {

                result = Math.min(result,
                        Math.abs(height[index] - height[index - jump])
                                + dp[index - jump]);
            }

            dp[index] = result;
        }

        // Maintain only last k DP values
        for (int index = k + 1; index < n; index++) {

            int result = Integer.MAX_VALUE;

            // Shift window
            for (int i = 1; i <= k; i++) {
                dp[i - 1] = dp[i];
            }

            // Calculate current answer
            for (int jump = 1; jump <= k; jump++) {

                result = Math.min(result,
                        Math.abs(height[index] - height[index - jump])
                                + dp[k - jump]);
            }

            dp[k] = result;
        }

        return dp[k];
    }
}