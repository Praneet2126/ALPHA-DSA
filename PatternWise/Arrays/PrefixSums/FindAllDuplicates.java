package PatternWise.Arrays.PrefixSums;

import java.util.*;

public class FindAllDuplicates {
    // Optimal Solution
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            int x = Math.abs(nums[i]);
            if(nums[x-1] < 0) {
                list.add(x);
            }
            nums[x-1] *= -1;
        }

        return list;
    }

    // HashMap solution
    public static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()) {
            if(map.get(key) > 1) {
                list.add(key);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }
}
