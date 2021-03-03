package t05_sort;

/**
 * - 버전 번호를 version1하고 version2, 비교한다.
 * - 다음을 반환합니다.
 * - 이면 version1 < version2 반환 -1합니다.
 * - 이면 version1 > version2 반환 1합니다.
 * - 그렇지 않으면을 0반환.
 *
 * Input:
 *  String version1 = "8.5.2.4",
 *  version2 = "8.5.3";
 * Output: -1
 *
 * Note
 * Integer a = 1, b = 3;
 * 오름차순 -1, 오른쪽 큰값
 * a.compareTo(b); // -1
 */
public class T02_compareToTest {

    public static void main(String[] args) {
        String version1 = "8.5.2.4", version2 = "8.5.3";
//		String version1 = "1.0.1", version2 = "1";
        System.out.println(compareVersion(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("[.]");    // 정규식에서 "." 을 점 그대로 인식시키기 위해선 "[.]"  또는  "\\."
        String[] v2 = version2.split("[.]");

        int length = Math.max(v1.length, v2.length);

        for (int i = 0; i < length; i++) {
            Integer v1Int = i < v1.length ? Integer.parseInt(v1[i]) : 0;    // 계속 같다가 서로 길이가 안맞으면 index 예외 발생하므로 0
            Integer v2Int = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            int comp = v1Int.compareTo(v2Int);

            if (comp != 0) {
                return comp;
            }
        }

        return 0;
    }

}
