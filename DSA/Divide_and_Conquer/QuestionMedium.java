package Divide_and_Conquer;

public class QuestionMedium {
    public static int majorityElement(int[] nums) {
        int number = 0, count = 0;
        for (int num : nums) {
         if (count == 0) {
          number = num;
         }
         count += (num == number) ? 1 : -1;
        }
        return number;
    }

    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
