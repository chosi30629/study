package t06_bfs_dfs;

/**
 * Input: matrix =
 *  [[9, 8, 3],
 *  [6, 5, 7],
 *  [2, 1, 1]]
 *
 * Output: 4
 *
 * 가장 긴 증가 경로는 [1, 2, 6, 9] 입니다.
 */
public class Basic_dfs01 {

    public static void main(String[] args) {
        int[][] grid = {
//            {9, 9, 4},
//            {6, 6, 8},
//            {2, 1, 1}
            {9, 8, 3},
            {6, 5, 7},
            {2, 1, 1}
        };

        System.out.println(solve(grid));
    }

    public static int solve(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int max = 1;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(grid, i, j, m, n, result);
                max = Math.max(max, len);
            }
        }

        return max;
    }

    private static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int dfs(int[][] grid, int i, int j, int m, int n, int[][] result) {
        if (result[i][j] != 0) {
            return result[i][j];
        }

        int max = 1;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] <= grid[i][j]) {
                continue;
            }

            int len = 1 + dfs(grid, x, y, m, n, result);
            max = Math.max(max, len);
        }

        result[i][j] = max;

        return max;
    }

    static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

}
