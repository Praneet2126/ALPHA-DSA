package PatternWise.Arrays.TwoPointers;

import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            int j = i+1;
            int k = nums.length-1;

            while(j < k) {
                int total = nums[i] + nums[j] + nums[k];          
                if(Math.abs(target - total) < diff) {
                    diff = Math.abs(target - total);
                    sum = total;
                }

                if(total <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        } 

        return sum;
    }
}
