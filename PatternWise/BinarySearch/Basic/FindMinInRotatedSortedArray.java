package PatternWise.BinarySearch.Basic;

public class FindMinInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = -1;

        while(left < right) {
            mid = left + (right - left)/2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];   
    }
    
    public static void main(String[] args) {
        int[] nums = {11,13,15,17};
        System.out.println(findMin(nums));
    }
}
