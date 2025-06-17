package Graphs;

public class MinimumDepth {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data= data;
            this.left = null;
            this.right = null;
        }
    }

    public static int minDepth(Node root) {
        if(root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return Math.min(leftDepth, rightDepth) + 1;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(6);
        root.left.right = new Node(5);
        root.right.left = new Node(9);

        System.out.println(minDepth(root));
    }
}
