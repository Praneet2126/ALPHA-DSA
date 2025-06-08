package Trees.BST;

import java.util.ArrayList;

public class BSTPractice {
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

    // Q1:
    public static int sum = 0;
    public static void rangeSum(Node root, int L, int R) {
        if(root == null) {
            return;
        }
        
        if(root.data >= L && root.data <= R) {
            sum += root.data;
        } else {
            return;
        }

        rangeSum(root.left, L, R);
        rangeSum(root.right, L, R);
    }
    

    // Q2:
    public static Node closestElement(Node root, int k) {
        int diff = Integer.MAX_VALUE;
        Node curr = root, closest = null;

        while(curr != null) {
            int currDiff = Math.abs(curr.data - k);
            if(currDiff < diff) {
                diff = currDiff;
                closest = curr;
            }

            if(k > curr.data) {
                curr = curr.right;
            } else if(k < curr.data){
                curr = curr.left;
            } else {
                return curr;
            }
        }

        return closest;
    }

    // Q3:
    public static void kthSmallest(Node root, int k, ArrayList<Integer> arr) {
        if (root == null || arr.size() >= k) {
            return;
        }

        kthSmallest(root.left, k, arr);
        
        if (arr.size() < k) {
            arr.add(root.data);
        }

        kthSmallest(root.right, k, arr);
    }

    
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);

        root.right = new Node(11);
        root.right.right = new Node(20);

        // rangeSum(root, 1, 2);
        // System.out.println("Sum = "+sum);

        // System.out.println(closestElement(root, 19).data);

        ArrayList<Integer> arr = new ArrayList<>();
        int k = 3;
        kthSmallest(root, k, arr);
        System.out.println(arr.get(k-1));
    }
}
