package PatternWise.Arrays.TwoPointers;

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int nums[], int target) {
        int res[] = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            } else {
                map.put(nums[i], i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 7, 11, 15 };
        int target = 9;
        int res[] = twoSum(nums, target);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
