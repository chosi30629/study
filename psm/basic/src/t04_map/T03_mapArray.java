package t04_map;

import java.util.*;

/**
 * - 배열이 주어지면 가장 빈도수가 높은 k 개의 요소를 return
 *
 * Example
 * Input :
 *  int[] nums = {1, 1, 2, 2, 2, 3, 5, 5, 5, 5};
 *  int k = 2;
 *
 * Output :
 *  [5, 2]
 *
 * Note
 * k값은 항상 주어짐
 */
public class T03_mapArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 5, 5, 5, 5};
//        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int k = 2;
        System.out.println(topFrequent(nums, k));
    }

    public static List<Integer> topFrequent(int[] nums, int k) {
        // 1. 담을 그릇
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] list = new List[nums.length + 1]; // 0 ~ 10
        List<Integer> result = new ArrayList<>();

        // 2. 맵에 getOrDefault
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println(map);

        // 3. List
        for (int key : map.keySet()) {
            int topFrequent = map.get(key); // value
            if (list[topFrequent] == null) {
                list[topFrequent] =  new ArrayList<>();
            }

            list[topFrequent].add(key); // key
        }

        System.out.println(Arrays.toString(list));

        // 4. List 에서 뽑아내기 k = 2
        for (int lastIndex = list.length - 1; lastIndex >= 0; lastIndex--) {
            if (list[lastIndex] != null) {
                for (int i = 0; i < list[lastIndex].size() && result.size() < k; i++) {
                    result.add(list[lastIndex].get(i));
                }
            }
        }

        return result;
    }

}
