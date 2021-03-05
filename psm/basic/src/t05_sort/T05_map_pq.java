package t05_sort;

import java.util.*;

/**
 * 입력 : [ "i", “study", “inflearn", "i", “study", "coding"], k = 2
 * 출력 : [ "i", “study"]
 * 입력 : { "a", "b", "c", "a", "b", "c" }, k = 2
 * 출력 : [ “a", “b"]
 *
 * 설명 : "i" 및 “study" 는 가장 자주 사용되는 두 단어입니다.
 * 알파벳 순서가 낮기 때문에 "i"가 “study"앞에옵니다.
 * 빈도를 기준으로 가장 높은 것에서 가장 낮은 것 순으로 정렬해야합니다.
 * 두 단어의 빈도가 같으면 알파벳 순서가 낮은 단어가 먼저옵니다.
 *
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class T05_map_pq {

    public static void main(String[] args) {
//        String[] words= {"i", "study", "inflearn", "i", "study", "coding"};
        String[] words = {"a", "b", "c", "a", "b", "c", "a"};
        int k = 2;
        System.out.println(solve(words, k));
    }

    public static List<String> solve(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue()
                        ? a.getKey().compareTo(b.getKey())
                        : b.getValue() - a.getValue());

        /*
        Comparator<Map.Entry<String, Integer>> comp = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                if (a.getValue() == b.getValue()) {
                    return a.getKey().compareTo(b.getKey());
                }

                return b.getValue() - a.getValue();
            }
        };

        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(comp);
        */

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        while (k > 0) {
            result.add(pq.poll().getKey());
            k--;
        }

        return result;
    }

}
