package Strings;
import java.util.*;

public class Anagrams {
    public static boolean anagram(String str1, String str2) {
        // safe side
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.length() != str2.length()) {
            return false;
        } else {
            char s1Array[] = str1.toCharArray();
            char s2Array[] = str2.toCharArray();

            Arrays.sort(s1Array);
            Arrays.sort(s2Array);

            if(Arrays.equals(s1Array, s2Array)) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public static void main(String[] args) {
        String s1 = "rage";
        String s2 = "care";
        System.out.println(anagram(s1, s2));
    }
}
