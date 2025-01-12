public class Practice {
    public static boolean func(int nums[]) {
        for(int i=0;i<nums.length; i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,8,9,7};
        System.out.println(func(nums));
    }
}
