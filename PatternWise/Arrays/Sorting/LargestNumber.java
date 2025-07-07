package PatternWise.Arrays.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            list.add(nums[i]+"");
        }
        
        // NOTE: Important step
        Collections.sort(list, (a, b) -> (b + a).compareTo(a + b)); 

        if (list.get(0).equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder("");
        for(String str : list) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int nums[] = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
