package t03_2DArray;

import java.util.HashSet;
import java.util.Set;

/**
 * - 주어진 행렬 m*n. 요소가 0 이면 전체 행과 열을 0으로 설정 합니다.
 * Input: matrix =
 * [
 *  [1,1,1],
 *  [1,0,1],
 *  [1,1,1]
 * ]
 *
 * Output:
 * [
 *  [1,0,1],
 *  [0,0,0],
 *  [1,0,1]
 * ]
 */
public class T03_matrixZeros {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

//		int[][] matrix ={
//            {1, 1, 1, 1},
//            {1, 0, 1, 1},
//            {1, 1, 0, 0},
//            {1, 0, 0, 1},
//        };

        solve(matrix);
    }

    public static void solve(int[][] grid) {
        print(grid);

        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    System.out.print("[" + i + "][" + j + "] " + grid[i][j] + " ");
                    row.add(i);
                    col.add(j);
                }
            }
            System.out.println();
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (row.contains(i) || col.contains(j)) {
                    System.out.print("[" + i + "][" + j + "] " + grid[i][j] + " ");
                    grid[i][j] = 0;
                }
            }
            System.out.println();
        }

        System.out.println();
        print(grid);
    }

    private static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print("[" + i + "][" + j + "] " + a[i][j] + " ");
            }
            System.out.println();
        }
    }
}