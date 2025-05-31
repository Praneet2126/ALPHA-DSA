package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class KthLevel {
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

    public static void printLevel(Queue<Node> q) {
        while(true) {
            Node currNode = q.remove();
            if(currNode == null) {
                break;
            }

            System.out.print(currNode.data+" ");
        }
    }

    public static void printKthLevel(Node root, int level) {
        if(root == null) {
            return;
        }

        int count = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null) {  
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                    count++;
                    if(count == level) {
                        printLevel(q);
                        return;
                    }
                }
            } else {
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7

        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printKthLevel(root, 0);
    }
}
