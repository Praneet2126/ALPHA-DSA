package Hashing;
import java.util.*;

public class IterationHashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(4);
        set.add(6);
        set.add(2);
        set.add(9);

        // Method a:
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
            System.out.print(it.next()+" ");
        }

        System.out.println();
        
        // Method b:
        for(Integer i : set) {
            System.out.print(i+" ");
        }
    }
}
