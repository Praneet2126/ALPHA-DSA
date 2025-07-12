package PatternWise.BinarySearch.Basic;

public class FindInsertPos {
    public static int findPos(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;
            if(target == nums[mid]) {
                return mid;
            } else if(target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,3,4,6,7,9};
        int target = 10;

        System.out.println(findPos(nums, target));
    }
}
