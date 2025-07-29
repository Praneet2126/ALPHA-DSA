package PatternWise.Trees.RootToLeaf;

import java.util.*;

public class MaximumWidth {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair {
        TreeNode node;
        int num;

        public Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().num;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                int currId = q.peek().num - mmin;
                TreeNode node = q.remove().node;
                if (i == 0)
                    first = currId;
                if (i == size)
                    last = currId;
                if (node.left != null) {
                    q.add(new Pair(node.left, currId * 2 + 1));
                }
                if (node.right != null) {
                    q.add(new Pair(node.right, currId * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
