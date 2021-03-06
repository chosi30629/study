package t06_bfs_dfs;

/**
 * char[][] grid = {
 * { '1', '1', '0', '0', '1' },
 * { '1', '1', '0', '0', '0' },
 * { '0', '0', '0', '0', '0' },
 * { '0', '0', '0', '1', '1' } };
 *
 * 1: 육지, 2: 바다
 *
 * 출력 : 3 (육지 개수)
 */
public class Basic_dfs {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '0', '0', '0', '1'},
                {'0', '0', '0', '0', '0', '1', '1'},
                {'1', '0', '0', '1', '1'}
        };

        System.out.println(numberOfIsland(grid));
    }

    private static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static int numberOfIsland(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] != '1') {
            return;
        }

        System.out.println("x " + x + ", y " + y);
        grid[x][y] = '0';

        for (int[] dir : dirs) {
            dfs(grid, x + dir[0], y + dir[1]);
        }
    }

}
