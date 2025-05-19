package Lv2.Nx2타일링;

public class Solution {
    static final int MOD = 1000000007;

    public static int solution(int n) {
        int answer = 0;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; ++i) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
        }

        answer = dp[n];

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6));
    }
}


