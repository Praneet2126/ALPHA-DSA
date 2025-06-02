package Trees.BST;

import java.util.ArrayList;

public class BinarySearchTree {
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

    // NOTE: BUILD BINARY SEARCH TREE
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


    // NOTE: INORDER TRAVERSAL FOR SORTED SEQUENCE
    public static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }


    // NOTE: SEARCH IN BST
    public static boolean search(Node root, int key) { // O(H)
        if(root == null) {
            // System.out.println("Not found");
            return false;
        }

        if(root.data == key) {
            // System.out.println("Found");
            return true;
        }

        if(key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }


    // NOTE: UTILITY FOR DELETE
    public static Node findInorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }


    // NOTE: DELETE NODE
    public static Node delete(Node root, int val) {
        if(val > root.data) {
            root.right = delete(root.right, val);
        } 
        else if(val < root.data) {
            root.left = delete(root.left, val);
        }
        else {
            //case 1: leaf node
            if(root.left == null && root.right == null) {
                return null;
            }

            //case 2: one child
            if(root.left == null) {
                return root.right;
            } 
            else if(root.right == null) {
                return root.left;
            }

            //case 3: two children
            Node successor = findInorderSuccessor(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }

        return root;
    }


    // NOTE: PRINT IN RANGE K1 & K2
    public static void printInRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }
        
        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1) {
            printInRange(root.left, k1, k2);
        }
        else {
            printInRange(root.right, k1, k2);
        }
    }


    // NOTE: PRINT ROOT TO LEAF PATHS
    public static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size()-1; i++) {
            System.out.print(path.get(i)+"->");
        }
        System.out.print(path.get(path.size()-1));
        System.out.println();
    }
    
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
        
        path.add(root.data);
        if(root.left == null && root.right == null) {
            printPath(path);
        }
        
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }


    // NOTE: MAIN FUNCTION
    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};   
        Node root = null;

        for(int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }

        // inorder(root);
        // System.out.println();
        // System.out.print(search(root, 9));
        // root = delete(root, 5);

        // printInRange(root, 5, 12);

        ArrayList<Integer> path = new ArrayList<>();
        printRoot2Leaf(root, path);
    }
}
