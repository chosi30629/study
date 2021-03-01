package t02_array;

import java.util.HashMap;
import java.util.Map;

/**
 * Integer array nums, k 가 있다.
 * return the total number of continuous subarrays
 * whose sum equals to k.
 *
 * 입력 : int[] nums= { 3, 4, 7, 2, -3, 1, 4, 2 };
 * int k=7
 * 출력 : 4
 */
public class T03_subArraySum_map {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 7, 2, -3, 1, 4, 2 };
        int k = 7;
        System.out.println(subarraySum_map(nums, k));
    }

    public static int subarraySum_map(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}
