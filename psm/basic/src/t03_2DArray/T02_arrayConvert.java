package t03_2DArray;

import java.util.ArrayList;
import java.util.List;

public class T02_arrayConvert {

    public static void main(String[] args) {
        int[][] a = {
            {1, 2, 3},
            {4, 5, 6, 10, 11},
            {7, 8, 9, 20}
        };

        // 1. 2dArray -> list
        List<List<Integer>> list = convert2dArrayToList(a);
        System.out.println(list);

        // 2. list -> 2dArray
        int[][] arr = convertListTo2dArray(list);
        print(arr);
    }

    public static List<List<Integer>> convert2dArrayToList(int[][] a) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < a[i].length; j++) {
                list.add(a[i][j]);
            }

            result.add(list);
        }

        return result;
    }

    public static int[][] convertListTo2dArray(List<List<Integer>> list) {
        // fixed 무조건 만들어놔야함
        int[][] result = new int[list.size()][];    // 행을 알아낸다.

        for (int i = 0; i < result.length; i++) {
            result[i] = new int[list.get(i).size()];    // column 열이 항상 다르니까 이 부분 fixed
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                result[i][j] = list.get(i).get(j);
            }
        }

        return result;
    }

    private static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

}
