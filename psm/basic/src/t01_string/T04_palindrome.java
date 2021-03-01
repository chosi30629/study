package t01_string;

/**
 *  Input: s = "bananas"
 *  Output: "anana"
 *
 *  Input: s = "babad"
 *  Output: "bab”
 *
 *  return the longest palindromic substring in s
 */
public class T04_palindrome {

    public static void main(String[] args) {
        T04_palindrome a = new T04_palindrome();
        String s = "bananas";
//        String s = "asdkemme";
//        String s = "asdkemmmme";

        System.out.println(a.solve(s));
    }

    private int start;
    private int end; // end 는 가장 긴 팰린드롬(회문)의 길이

    public String solve(String s) {
        int len = s.length();

        System.out.println("len " + len);

        if (len < 2) {
            return s;
        }

        for (int i = 0; i < len - 1; i++) {
            findSubstring(s, i, i);             // 홀수(기준 문자열 1개)
            findSubstring(s, i, i + 1); // 짝수(기준 문자열 2개)
        }

        System.out.println("start " + start + " end " + end + " start+end " + (start + end));

        return s.substring(start, start + end);
    }

    private void findSubstring(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            System.out.println(left+","+right+","+s.substring(left,right+1));

            left--;
            right++;
        }

        System.out.println("left " + left + " right " + right);

        if (end < right - left - 1) {
            end = right - left - 1; // 6, 위에서 right++ 로 끝났으므로 -1
            start = left + 1; // 0, 위에서 left-- 로 끝났으므로 + 1

            System.out.println("end   " + end + "   ============================= right " + right);
        }

        System.out.println();
    }

}
