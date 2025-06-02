package Trees;

public class Practice {
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

    public static boolean univalued(Node root) {
        if(root == null) {
            return true;
        }

        if(root.left != null && root.data != root.left.data) {
            return false;
        }
        
        if(root.right != null && root.data != root.right.data) {
            return false;
        }

        return univalued(root.left) && univalued(root.right);
    }
    
    public static void main(String[] args) {
        /*
                 2
               /   \
              2     2
             / \   / \
            2   2 2   2

        */

        Node root = new Node(2);
        root.left = new Node(2);
        root.left.left = new Node(2);
        root.left.right = new Node(2);
        root.right = new Node(2);
        root.right.left = new Node(5);
        root.right.right = new Node(2);

        System.out.println(univalued(root));
    }
}

