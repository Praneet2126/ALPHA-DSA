package Recursion;

public class RemoveDuplicatesString {
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        // base
        if(idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        //kaam
        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true) {
            removeDuplicates(str, idx+1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            newStr.append(currChar);
            removeDuplicates(str, idx+1, newStr, map);
        }
    }
    
    public static void main(String[] args) {
        String str = "appnnacollege";
        int idx = 0;
        StringBuilder sb = new StringBuilder("");
        boolean map[] = new boolean[26];

        removeDuplicates(str, idx, sb, map);
    }   
}
