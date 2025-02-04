package ArrayList;

import java.util.*;

public class Questions {
    public static List<Integer> lonelyNumbers(int[] nums) {
        Arrays.sort(nums);  // Sort the array

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; 
            }

            // lonely
            boolean leftNeighbor = (i > 0) && (nums[i - 1] == nums[i] - 1 || nums[i - 1] == nums[i]);
            boolean rightNeighbor = (i < nums.length - 1) && (nums[i + 1] == nums[i] + 1 || nums[i + 1] == nums[i]);

            if (!leftNeighbor && !rightNeighbor) {
                list.add(nums[i]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int nums[] = {10,8,5,6}; 
        System.out.println(lonelyNumbers(nums)); 
    }
}
