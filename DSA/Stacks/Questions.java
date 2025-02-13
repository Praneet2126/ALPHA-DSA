package Stacks;

import java.util.*;

public class Questions {
    public static boolean palindromeLinkedList(LinkedList<Character> ll) {
        Stack<Character> s = new Stack<>();
        
        int i=0;
        while(i < ll.size()/2) {
            s.push(ll.get(i));
            i++;
        }

        if (ll.size() % 2 != 0) {
            i++;
        }

        while(!s.isEmpty()) {
            if(s.peek() == ll.get(i)) {
                s.pop();
            } else {
                return false;
            }
            i++;
        }

        if(s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        LinkedList<Character> ll = new LinkedList<>();
        ll.addLast('A');
        ll.addLast('B');
        ll.addLast('C');
        ll.addLast('B');
        ll.addLast('A');

        System.out.println(palindromeLinkedList(ll));
    }
}
