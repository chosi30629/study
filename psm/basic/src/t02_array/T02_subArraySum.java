package t02_array;

/**
 * Integer array nums, k 가 있다.
 * return the total number of continuous subarrays
 * whose sum equals to k.
 *
 * 입력 : int[] nums= { 3, 4, 7, 2, -3, 1, 4, 2 };
 * int k=7
 * 출력 : 4
 */
public class T02_subArraySum {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 7, 2, -3, 1, 4, 2 };
        int k = 7;
        System.out.println(subarraySum(nums, k));
    }

    //  1. 이중 for
    public static int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

}
