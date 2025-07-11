package PatternWise.Arrays.SlidingWindow;

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int cs = 0;

        for(int right = 0; right < nums.length; right++) {
            cs += nums[right];
            while(cs >= target) {
                minLen = Math.min(minLen, right-left+1);
                cs -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
}
