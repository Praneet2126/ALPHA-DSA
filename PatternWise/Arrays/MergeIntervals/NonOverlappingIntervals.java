package PatternWise.Arrays.MergeIntervals;

import java.util.*;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        int[] current = intervals[0];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] >= current[1]) {
                current = intervals[i];
                count++;
            }
        }

        return intervals.length - count - 1;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
