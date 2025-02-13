package Stacks;

import java.util.*;

public class ReverseString {
    public static String reverse(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            s.push(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            sb.append(s.peek());
            s.pop();
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("abc"));
    }
}
