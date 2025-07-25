package PatternWise.Trees.Traversal;
import java.util.*;

public class Trees {
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

    static int idx = -1;
    public static Node buildTree(int nodes[]) {
        idx++;
        if(nodes[idx] == -1) {
            return null;
        }

        Node temp = new Node(nodes[idx]);
        temp.left = buildTree(nodes);
        temp.right = buildTree(nodes);

        return temp;
    }

    public static void inorder(Node root, List<Integer> list) {
        if(root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public static void levelOrder(Node root, List<List<Integer>> list) {
        if(root == null) return;
        
        List<Integer> temp = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node curr = q.remove();
            if(curr == null) {
                list.add(temp);
                temp = new ArrayList<>();
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                temp.add(curr.data);
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    // ZigZag - Method 1
    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, list);

        for(int i=1; i<list.size(); i+=2) {
            Collections.reverse(list.get(i));
        }

        return list;
    }

    // Method 2 - Deque Approach
    public static List<List<Integer>> zigzagLevelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<Node> q = new LinkedList<>();
        q.addFirst(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            List<Integer> current = new ArrayList<>();
            int level = q.size();

            for (int i = 0; i < level; i++) {
                if (!reverse) {
                    Node curr = q.removeFirst();
                    current.add(curr.data);
                    if (curr.left != null) q.addLast(curr.left);
                    if (curr.right != null) q.addLast(curr.right);
                } else {
                    Node curr = q.removeLast();
                    current.add(curr.data);
                    if (curr.right != null) q.addFirst(curr.right);
                    if (curr.left != null) q.addFirst(curr.left);
                }
            }

            res.add(current);
            reverse = !reverse;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildTree(nodes);

        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        System.out.println(list);

        List<List<Integer>> levelOrderList = new ArrayList<>();
        levelOrder(root, levelOrderList);
        System.out.println(levelOrderList);

        List<List<Integer>> zigZagList = new ArrayList<>();
        zigZagList = zigzagLevelOrder(root);
        System.out.println(zigZagList);

        zigZagList.clear();
        zigZagList = zigzagLevelOrder2(root);
        System.out.println(zigZagList);
    }
}
