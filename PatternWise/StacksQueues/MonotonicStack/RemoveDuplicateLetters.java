package PatternWise.StacksQueues.MonotonicStack;

import java.util.*;

public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] frequency = new int[26];
        boolean[] visited = new boolean[26];

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            frequency[ch - 'a']++;
        }

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(visited[ch - 'a']) {
                frequency[ch - 'a']--;
                continue;
            }
            
            while(!stack.isEmpty() && stack.peek() > ch && frequency[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
            frequency[ch - 'a']--;
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}
