package Lv2.석유시추;

import java.util.*;

public class Solution {
    static int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0},
                            {0, 0, 0, 0, 1, 1, 0, 0},
                            {1, 1, 0, 0, 0, 1, 1, 0},
                            {1, 1, 1, 0, 0, 0, 0, 0},
                            {1, 1, 1, 0, 0, 0, 1, 1}};

    static int[][] land2 = {{1, 0, 1, 0, 1, 1},
                            {1, 0, 1, 0, 0, 0},
                            {1, 0, 1, 0, 0, 1},
                            {1, 0, 0, 1, 0, 0},
                            {1, 0, 0, 1, 0, 1},
                            {1, 0, 0, 0, 0, 0},
                            {1, 1, 1, 1, 1, 1}};

    static int rows, cols;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};    // 상하좌우 이동 (x 방향)
    static int[] dy = {0, 0, -1, 1};    // 상하좌우 이동 (y 방향)
    static int[] oil;

    // static int count;
/*public static void dfs(int row, int col, int[][] land) {
        if ((row < 0) || (row >= rows) || (col < 0) || (col >= cols) || visited[row][col] || land[row][col] == 0) {
            return;
        }

        visited[row][col] = true;
        // ++count;

        dfs(row - 1, col, land);  // 좌
        dfs(row + 1, col, land);  // 우
        dfs(row, col - 1, land);  // 상
        dfs(row, col + 1, land);  // 하
    }*/


    public static void bfs(int row, int col, int[][] land) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        int oilCount = 1;
        Set<Integer> set = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] current = queue.poll();  // 큐의 최상위 요소(헤드) 반환 및 제거 메서드 (스택 pop() 같은거)
            // 현재 위치 [curRow, curCol]
            int curRow = current[0];
            int curCol = current[1];
            set.add(curCol);

            for (int i = 0; i < 4; ++i) {   // 상하좌우 이동
                int nRow = curRow + dx[i];  // 이동할 row
                int nCol = curCol + dy[i];  // 이동할 col

                if (!checkRange(nRow, nCol))
                    continue;

                // 석유가 있으면서 방문한 적 없는 경우
                if (!visited[nRow][nCol] && land[nRow][nCol] == 1) {
                    queue.add(new int[]{nRow, nCol});   // 큐에 추가
                    visited[nRow][nCol] = true;
                    ++oilCount;
                }
            }
        }

        for (int index : set) {
            oil[index] += oilCount;
        }
    }

    // 범위 유효성 검사
    public static boolean checkRange(int nRow, int nCol) {
         return (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols);
    }

    public static int solution(int[][] land) {
        int answer = 0;

        rows = land.length;
        cols = land[0].length;

        visited = new boolean[rows][cols];
        oil = new int[cols];

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (land[row][col] == 1 && !visited[row][col]) {
                    // dfs(row, col, land);
                    bfs(row, col, land);
                }
            }
        }

        // answer = Arrays.stream(oil).max().getAsInt();
        for (int i : oil) {
            if (answer < i) {
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(land));
        System.out.println(solution(land2));
    }
}
