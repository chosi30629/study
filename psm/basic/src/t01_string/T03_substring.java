package t01_string;

/**
 * Input: String str[] = { “test”, “teacher" }
 * Output: “te”
 *
 * 앞자리 te를 리턴한다.
 */
public class T03_substring {

    public static void main(String[] args) {
        String str[] = { "test", "teacher" };
        System.out.println(new T03_substring().solve(str));
    }

    public String solve(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 1 test
        String firstStr = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(firstStr) != 0) {    // 만약 대상이 없으면 firstStr.substring(0, 0) 은 "" 이고 strs[i]의 indexOf("") 는 0 임
                firstStr = firstStr.substring(0, firstStr.length() - 1);    // test, tes, te
            }
        }

        return firstStr;
    }

}
