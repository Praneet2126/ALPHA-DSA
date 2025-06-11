package Hashing;
import java.util.*;

public class OtherHashMaps {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("USA", 120);

        TreeMap<String,Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("USA", 120);

        System.out.println(lhm);
        System.out.println(tm);
    }
}
