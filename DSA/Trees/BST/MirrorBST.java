package Trees.BST;

public class MirrorBST {
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

    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }
    
    // NOTE: MIRROR THE TREE
    public static Node mirror(Node root) {
        if(root == null) {
            return null;
        }

        Node leftS = mirror(root.left);
        Node rightS = mirror(root.right);

        root.left = rightS;
        root.right = leftS;

        return root;
    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int values[] = {8,5,10,3,6,11};
        Node root = null;

        for(int data : values) {
            root = insert(root, data);
        }

        preorder(root);
        System.out.println();
        
        root = mirror(root);
        preorder(root);
    }
}
