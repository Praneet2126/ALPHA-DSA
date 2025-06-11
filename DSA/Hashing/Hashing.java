package Hashing;
import java.util.*;

public class Hashing {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Insert
        map.put("India",100);
        map.put("Russia",90);
        map.put("USA", 80);

        System.out.println(map);

        // Get
        System.out.println(map.get("Indonesia"));

        // ContainsKey
        System.out.println(map.containsKey("Indo"));

        // Remove
        System.out.println(map.remove("USA"));
        System.out.println(map);    

        System.out.println(map.size());

        System.out.println(map.isEmpty());

        map.clear();
        System.out.println(map);
    }
}
