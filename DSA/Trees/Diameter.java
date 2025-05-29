package Trees;

public class Diameter {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int diameter(Node root) {  // O(n^2)
        if(root == null) {
            return 0;
        }

        int ldiam = diameter(root.left);
        int rdiam = diameter(root.right);
        int lh = height(root.left);
        int rh = height(root.right);
        int selfDiam = lh + rh + 1;
        return Math.max(selfDiam, Math.max(ldiam, rdiam));
    }

    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info optimizedDiam(Node root) {  // O(n)
        if(root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = optimizedDiam(root.left);
        Info rightInfo = optimizedDiam(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \   \
            4   5   6

         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        System.out.println(optimizedDiam(root).diam);
    }
}
