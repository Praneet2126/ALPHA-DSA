package Hashing;

import java.util.*;

public class IterationOnHashMaps {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("India", 100);
        map.put("China", 150);
        map.put("USA", 180);
        map.put("Russia", 190);
        map.put("Nepal", 70);

        // Iterate
        Set<String> keys = map.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key:" + k + ", Value:"+map.get(k));
        }

    }
}
