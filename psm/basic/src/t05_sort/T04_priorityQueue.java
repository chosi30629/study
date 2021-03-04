package t05_sort;

import java.util.PriorityQueue;

/**
 * 양의 정수 길이의 두 막대기 연결할 수 있다.
 * x와 y의 비용을 지불한다. 스틱 x + y =>
 * 이런식으로 연결하여 스틱이 하나만 남을 때까지 모든 스틱을 연결 후 최소 비용을 반환합니다.
 *
 * 입력 : 스틱 = [1, 8, 3, 5]
 * 출력 : 30
 * 설명 :
 * 1. 1 + 3 = 4의 비용, = [4, 8, 5]가 됩니다.
 * 2. 4 + 5 = 9의 비용, = [9, 8]이 됩니다.
 * 3. 9 + 8 = 17의 비용, = [17]이 됩니다.
 * 스틱이 하나만 남아 있으므로 완료
 * 총 비용은 4 + 9 + 17 = 30입니다.
 */
public class T04_priorityQueue {

    public static void main(String[] args) {
        int[] sticks = {1, 8, 3, 5};
        System.out.println(pqSticks(sticks));
    }

    public static int pqSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // default = minHeap

        for (int stick : sticks) {
            pq.offer(stick);
        }

        int sum = 0;

        while (pq.size() > 1) {
            int twoSum = pq.poll() + pq.poll();
            sum += twoSum;
            pq.offer(twoSum);

            System.out.println(pq);
        }

        return sum;
    }

}
