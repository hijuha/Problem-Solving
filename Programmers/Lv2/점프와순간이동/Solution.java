package Lv2.점프와순간이동;

public class Solution {
    public static int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 2;
            n = n / 2;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5000;
        int answer = solution(n);

        System.out.println(answer);
    }
}
