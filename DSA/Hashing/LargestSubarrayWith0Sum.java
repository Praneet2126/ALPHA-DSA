package Hashing;
import java.util.*;

public class LargestSubarrayWith0Sum {
    public static int getLength(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int len = 0;

        for(int j=0; j<arr.length; j++) {
            sum += arr[j];
            if(map.containsKey(sum)) {
                int subArrayLength = j - map.get(sum);
                len = Math.max(subArrayLength, len); 
            } else {
                map.put(sum, j);
            }
        }

        return len;
    }
    
    public static void main(String[] args) {
        int arr[] = {15,-2,2,-8,1,7,10};
        System.out.println(getLength(arr));
    }
}
