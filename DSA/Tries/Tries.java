package Tries;

public class Tries {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        
        public Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();
    
    public static void insert(String word) {  // O(L)
        Node curr = root;
        for(int level=0; level<word.length(); level++) {
            char ch = word.charAt(level);
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new Node();
            } 
            curr = curr.children[ch-'a'];
        }
        curr.eow = true;
    }

    public static boolean search(String key) { // O(L)
        Node curr = root;
        for(int level=0; level<key.length(); level++) {
            char ch = key.charAt(level);
            if(curr.children[ch-'a'] == null) {
                return false;
            }
            curr = curr.children[ch-'a'];
        }
        
        return curr.eow; 
    }

    public static boolean wordBreak(String key) { // O(L)
        if(key.length() == 0) {
            return true;
        }

        for(int i=1; i<=key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        
        return false;
    }

    public static boolean startsWith(String prefix) {   // app
        Node curr = root;
        for(int i=0; i<prefix.length(); i++) {
            int idx = prefix.charAt(i)-'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
        
        // String key = "ilikesung";
        // System.out.println(wordBreak(key));

        System.out.println(startsWith("samsh"));
    }
}
