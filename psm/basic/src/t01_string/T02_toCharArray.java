package t01_string;

/**
 * Input: String s = "in(f(lea)r)n)";
 * Output: “in(f(lea)r)n”
 *
 * Input: String s = “(a(b(c)d)";
 * Output: “(a(bc)d)”
 *
 * 최소 괄호의 수를 제거하여 '(' ')' 처럼 유효한 parentheses(쌍) string 을 리턴한다
 * 1. 빈 문자열이거나 소문자만 포함
 */
public class T02_toCharArray {

    public static void main(String[] args) {

//		String s = "(a(b(c)d)";
//		String s = "(((a(b(c(e(f)d))";
//	    String s = "in(f(lea)r)n)";
//		String s = "a)b(c)d";
//		String s = "a)b(c)d)";

//		String s = "(()))";
//		String s = "(()";
//	    String s = "))((";
//	    String s = "((((";

	    String s = ")()(";

        System.out.println(new T02_toCharArray().solve(s));
    }

    public String solve(String s) {
        // 1
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int openBrace = 0;  // '('

        // 2 openBrace 1
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openBrace++;
            } else if (c == ')') {
                if (openBrace == 0) {
                    continue;
                }

                openBrace--;
            }

            sb.append(c);   // '(' 없이 ')' 먼저 나온 것을 버린 문자열
        }

        // 3
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && openBrace-- > 0) {
                continue;
            }

            result.append(sb.charAt(i));
        }

        return result.reverse().toString();
    }

}
