package Hashing;
import java.util.*;

public class BottomViewOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static class Info {
        int hd;
        Node node;

        public Info(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static List<Integer> bottomView(Node root) {
        Queue<Info> q = new LinkedList<>();
        Map<Integer, Node> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        int min = 0;
        int max = 0;
        q.add(new Info(0, root));
        q.add(null);

        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                map.put(curr.hd, curr.node);
                
                if(curr.node.left != null) {
                    q.add(new Info(curr.hd-1, curr.node.left));
                    min = Math.min(curr.hd-1, min);
                }

                if(curr.node.right != null) {
                    q.add(new Info(curr.hd+1, curr.node.right));
                    max = Math.max(curr.hd+1, max);
                }
            }
        }

        for(int i=min; i<=max; i++) {
            res.add(map.get(i).data);
        }

        return res;
    }
    
    public static void main(String[] args) {
        /* 
             20
            /  \
           8   22
          / \    \
         5   3   25
            / \
           10 14

        */   

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println(bottomView(root));
    }
}
