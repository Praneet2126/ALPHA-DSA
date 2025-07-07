package PatternWise.Arrays.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: Add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval); 

        // Step 3: Add remaining intervals
        while (i < n) {
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }
    public static void main(String[] args) {
        int intervals[][] = {{1,3}, {6,9}};
        int newInterval[] = {2,5};

        int res[][] = insert(intervals, newInterval);
        for(int[] arr : res) {
            System.out.println(arr[0]+" "+arr[1]);
        }
    }
}
