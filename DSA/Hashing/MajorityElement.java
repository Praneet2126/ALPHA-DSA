package Hashing;
import java.util.*;

public class MajorityElement {
    public static void printMajority(int nums[]) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Integer k : map.keySet()) {
            if(map.get(k) > nums.length/3) {
                System.out.print(k+" ");
            }
        }
    }
    
    public static void main(String[] args) {
        int nums[] = {1,2};
        printMajority(nums);
    }
}
