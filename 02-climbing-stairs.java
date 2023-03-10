/* Problem Statement:
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step */


// #1 Bottom Up DP
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
} // TC: O(n), SC: O(n)

// #2 Bottom Up Space Optimized
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2;
        for (int i = 1; i <= n-2; i++) {
            int tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }
} // TC: O(n), SC: O(1)

// #3 Top Down Memoized
class Solution {
    public int dfs(int n, int[] dp) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (dp[n] != 0)
            return dp[n];
        int step1 = dfs(n - 1, dp); // left
        int step2 = dfs(n - 2, dp); // right
        dp[n] = step1 + step2;
        return dp[n];
    }
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dfs(n, dp);
        return dp[n];
        /*if (n == 0) return 1;
        if (n < 0) return 0;
        int step1 = climbStairs(n-1); // left
        int step2 = climbStairs(n-2); // right
        return step1 + step2; */
    }
} // TC: O(n), SC: O(n)
