package Hashing;
import java.util.*;

public class HashSets {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(4);
        set.add(1);
        set.add(2);

        System.out.println(set);

        if(set.contains(8)) {
            System.out.println(true);
        }

        set.remove(2);
        System.out.println(set);
    }
}
