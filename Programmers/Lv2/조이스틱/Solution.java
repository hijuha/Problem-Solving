package Lv2.조이스틱;

import static java.lang.Math.min;

public class Solution {
    public static int solution(String name) {
        int count = 0;
        int n = name.length();
        int leftRightMove = n - 1;  // 오른쪽으로 계속 이동 (이동 최대 값)

        for (int x = 0; x < n; ++x) {
            if (name.charAt(x) < 'N') {
                count += name.charAt(x) - 'A';
            }
            else {
                count += 'Z' + 1 - name.charAt(x);
            }

            int y = x + 1;  // y = x 다음 문자 중에 A가 아닌 문자 위치
            while (y < n && name.charAt(y) == 'A') // A 아닌 문자 나올 때 까지 ++y
                ++y;

            /*
                나올 수 있는 Case는 2가지
                1. 원점 기준 오른쪽으로 x까지 탐색 후 왼쪽으로 이동해 y 탐색
                    - 오른쪽 x 이동 + 왼쪽 x 이동(원점) + 왼쪽 y 이동
                2. 원점 기준 왼쪽으로 y까지 탐색 후 오른쪽으로 이동해 x 탐색
                    - 왼쪽 y 이동 + 오른쪽 y 이동(원점) + 오른쪽 x 이동

                leftRightMove와 min(Case1, Case2) 중 작은 값 비교하면서 최소 이동 거리 구함
             */
            int case1 = x + x + (n - y);
            int case2 = (n - y) + (n - y) + x;
            leftRightMove = min(leftRightMove, min(case1, case2));
        }

        count += leftRightMove;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("JAN"));
        System.out.println(solution("JAZ"));
    }
}
