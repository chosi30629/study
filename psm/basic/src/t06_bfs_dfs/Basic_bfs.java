package t06_bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * char[][] grid = {
 * { '1', '1', '0', '0', '1' },
 * { '1', '1', '0', '0', '0' },
 * { '0', '0', '0', '0', '0' },
 * { '0', '0', '0', '1', '1' } };
 * <p>
 * 1: 육지, 2: 바다
 * <p>
 * 출력 : 3 (육지 개수)
 */
public class Basic_bfs {

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '1'},
            {'1', '1', '0', '0', '0', '0', '1'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        System.out.println(numberOfIsland(grid));
    }

    private static int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    private static int numberOfIsland(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void bfs(char[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int[] dir : dirs) {
                int x1 = point[0] + dir[0];
                int y1 = point[1] + dir[1];
                //                                            y1 < grid[x1].length 각 행의 열 길이에 맞게 설정
                if (x1 >= 0 && y1 >= 0 && x1 < grid.length && y1 < grid[x1].length && grid[x1][y1] == '1') {
                    grid[x1][y1] = '0';
                    queue.offer(new int[] {x1, y1});
                }
            }
        }
    }

}
