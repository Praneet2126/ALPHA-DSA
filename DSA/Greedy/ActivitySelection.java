package Greedy;

import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = {1, 0, 8, 5, 5, 3};
        int end[] = {2, 6, 9, 7, 9, 4};

        int activities[][] = new int[start.length][3];

        // Storing index, start, and end time
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;   
            activities[i][1] = start[i]; 
            activities[i][2] = end[i];
        }

        // Sorting by end time
        Arrays.sort(activities, Comparator.comparingInt(o -> o[2]));

        // Select activities greedily
        int maxAct = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(activities[0][0]); 
        int lastEnd = activities[0][2]; 

        for (int i = 1; i < start.length; i++) { 
            if (activities[i][1] >= lastEnd) { 
                maxAct++;
                list.add(activities[i][0]);
                lastEnd = activities[i][2]; 
            }
        }

        // Output results
        System.out.println("Max activities = " + maxAct);
        for (Integer i : list) {
            System.out.print("A" + i + " ");
        }
    }
}
