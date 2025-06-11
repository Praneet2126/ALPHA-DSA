package Hashing;

import java.util.*;

public class FrequencySort {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a,b) -> b.getValue() - a.getValue()
        );

        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.remove();
            sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return sb.toString();
    }    

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}
