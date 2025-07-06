package PatternWise.Arrays.MergeIntervals;

import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];

        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] <= current[1]) { // overlap condition
                current[1] = Math.max(intervals[i][1], current[1]);
            } else {
                list.add(current);
                current = intervals[i];
            }
        }
        list.add(current);

        return list.toArray(new int[list.size()][]);
    }
    
    public static void main(String[] args) {
        int[][] intervals = {{0,2},{1,4},{3,5}};
        int res[][] = merge(intervals);
        for(int i=0; i<res.length; i++) {
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }
}
