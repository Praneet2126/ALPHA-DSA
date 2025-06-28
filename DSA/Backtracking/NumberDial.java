package Backtracking;

import java.util.*;

public class NumberDial {
    public static void dial(String digits, String[] keys, int n, String str, List<String> list) {
        if(n == digits.length()) {
            // System.out.println(str);
            list.add(str);
            return;
        }
        
        int chIdx = digits.charAt(n) - '0';
        for(int i=0; i<keys[chIdx].length(); i++) {
            dial(digits, keys, n+1, str+keys[chIdx].charAt(i),list);
        }
    }
    
    public static void main(String[] args) {
        String digits = "23";
        String[] keys = {"oper",null,"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        List<String> list = new ArrayList<>();
        dial(digits, keys, 0, "", list);

        for(String str : list) {
            System.out.println(str);
        }
    }
}
