package Trees.BST;

import java.util.ArrayList;

public class BSTToBalancedBST {
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

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node createBST(ArrayList<Integer> arr, int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = start + (end - start)/2;
        Node root = new Node(arr.get(mid)); 

        root.left = createBST(arr, start, mid-1);
        root.right = createBST(arr, mid+1, end);
        
        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if(root == null) {
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node balanceBST(Node root) {
        // inorder
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // Sorted inorder -> Balanced BST
        root = createBST(inorder, 0, inorder.size()-1);
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        preorder(root);
        System.out.println();
        root = balanceBST(root);
        preorder(root);
    }
}
