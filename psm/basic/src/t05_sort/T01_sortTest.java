package t05_sort;

public class T01_sortTest {

    public static void main(String[] args) {
        compareToTest();
    }

    public static void compareToTest() {
        Integer a = 1, b = 3;   
        System.out.println(a.compareTo(b)); // 오름차순 -1, 오른쪽 큰 값

        a = 3;
        b = 1;
        System.out.println(a.compareTo(b)); // 1, 왼쪽 큰 값

        a = 3;
        b = 3;
        System.out.println(a.compareTo(b)); // 0, 같음
    }

}
