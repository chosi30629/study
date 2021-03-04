package t05_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 */
public class T03_comparator {

    public static void main(String[] args) {
//        int[][] nums = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(15, 18));

        T03_comparator a = new T03_comparator();
        print(intervals);
        System.out.println();
        print(a.merge(intervals));
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return intervals;
        }

        Collections.sort(intervals, (a, b) -> a.start - b.start);   // 오름차순 정렬
//        Collections.sort(intervals, comp);
//        Collections.sort(intervals, comp2);

        List<Interval> result = new ArrayList<>();
        Interval before = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);

            if (before.end >= curr.start) {
                before.end = Math.max(before.end, curr.end);
            } else {
                result.add(before);
                before = curr;
            }
        }

        if (!result.contains(before)) {
            result.add(before);
        }

        return result;
    }

    Comparator comp = new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    };

    Comparator comp2 = new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b) {
            if (a.start < b.start) {
                return -1;
            } else if (a.start > b.start) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    static void print(List<Interval> list) {
        for (int i = 0; i < list.size(); i++) {
            Interval in = list.get(i);
            System.out.println(in.start + " " + in.end);
        }
    }

}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}