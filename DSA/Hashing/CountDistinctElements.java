package Hashing;
import java.util.*;

public class CountDistinctElements {
    public static void main(String[] args) {
        int nums[] = {4,3,2,5,6,7,3,4,2,1};

        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }

        System.out.println(set.size());
    }
}
