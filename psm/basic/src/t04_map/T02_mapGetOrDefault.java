package t04_map;

import java.util.HashMap;
import java.util.Map;

/**
 * - 주어진 문자열에서 반복되지 않는 첫 번째 문자를 찾아서 Index 를 return 합니다.
 * - 존재하지 않으면 -1을 반환합니다.
 *
 * Example
 * String s = "inflearninlove"
 *
 * Note
 * 문자열에 영문 소문자만 포함
 */
public class T02_mapGetOrDefault {

    public static void main(String[] args) {
        String s = "inflearninlove";
        System.out.println(solve(s));
    }

    public static int solve(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
//            if (!map.containsKey(c)) {
//                map.put(c, 1);
//            } else {
//                map.put(c, map.get(c) + 1);
//            }

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

}
