package Lv2.피보나치수;

public class Solution {
    public static int solution(int n) {
        if (n > 1)
            return (solution(n - 1) + solution(n - 2)) % 1234567;
        else
            return n;
    }

    public static int dpSolution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 2; i <= n; ++i) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(dpSolution(100000));
    }
}
