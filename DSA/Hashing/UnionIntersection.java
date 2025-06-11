package Hashing;
import java.util.*;

public class UnionIntersection {
    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        // Union
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr1) {
            set.add(i);
        }

        for(int i : arr2) {
            set.add(i);
        }

        int unionCount = set.size();

        set.clear();

        // Intersection
        int intersectionCount = 0;
        for(int i : arr1) {
            set.add(i);
        }

        for(int i : arr2) {
            if(set.contains(i)) {
                intersectionCount++;
                set.remove(i);
            }
        }

        System.out.println("Union = "+unionCount+", Intersection = "+intersectionCount);
    }   
}
