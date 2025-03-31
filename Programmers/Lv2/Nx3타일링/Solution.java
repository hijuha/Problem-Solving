package Lv2.Nx3타일링;

public class Solution {
    static long[] dp;
    static final int MOD = 1000000007;

    public static int solution(int n) {
        if (n % 2 == 1)
            return 0;

        int answer = 0;

        dp = new long[n+4];
        dp[2] = 3;
        dp[4] = 11;

        for (int i = 6; i <= n; i += 2) {
            dp[i] = (4 * dp[i-2] % MOD - dp[i-4] + MOD) % MOD;
        }

        answer = (int)dp[n];

        return answer;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(solution(n));
    }
}
