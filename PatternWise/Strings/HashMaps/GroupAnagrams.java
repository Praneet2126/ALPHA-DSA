package PatternWise.Strings.HashMaps;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();

        for(String str : strs) {
            String originalStr = str;

            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            str = new String(chars);

            if(map.containsKey(str)) {
                int idx = map.get(str);
                List<String> existing = list.get(idx);
                existing.add(originalStr);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(originalStr);
                list.add(temp);
                map.put(str, list.size()-1);
            }
        }

        return list;
    }

    public static void main(String[] args) {
       String[] strs= {"eat","tea","tan","ate","nat","bat"};
       System.out.println(groupAnagrams(strs));
    }
}
