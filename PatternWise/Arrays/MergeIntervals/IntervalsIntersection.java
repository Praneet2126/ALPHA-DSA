package PatternWise.Arrays.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalsIntersection {
    public static int[] getIntersection(int[] interval1, int[] interval2) {
        int res[] = new int[2];
        res[0] = Math.max(interval1[0], interval2[0]);
        res[1] = Math.min(interval1[1], interval2[1]);
        return res;
    }

    public static boolean isOverlapping(int[] interval1, int[] interval2) {
        return Math.max(interval1[0], interval2[0]) <= Math.min(interval1[1], interval2[1]);
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();

        if(firstList.length == 0 || secondList.length == 0) {
            return list.toArray(new int[list.size()][]);
        }

        int i=0, j=0;
        while(i < firstList.length && j < secondList.length) {
            int[] interval1 = firstList[i];
            int[] interval2 = secondList[j];
            
            if(isOverlapping(interval1, interval2)) {
                int[] intersection = getIntersection(interval1, interval2);
                list.add(intersection);
            }

            if(interval1[1] >= interval2[1]) {
                j++;
            } else {
                i++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        
        int[][] res = intervalIntersection(firstList, secondList);
        for(int[] arr : res) {
            System.out.println(arr[0]+","+arr[1]);
        }
    }
}
