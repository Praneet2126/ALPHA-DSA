package PatternWise.Trees.Construction;

import java.util.*;

public class PreorderPostorder {
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

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    public static TreeNode build(int[] preorder, int s1, int e1, int[] postorder, int s2, int e2,
            Map<Integer, Integer> map) {
        if (s1 > e1 || s2 > e2) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[s1]);
        if (s1 == e1)
            return root; // base case for one node
        int postRootIdx = map.get(preorder[s1 + 1]);
        int leftSize = postRootIdx - s2 + 1;

        root.left = build(preorder, s1 + 1, s1 + leftSize, postorder, s2, postRootIdx, map);
        root.right = build(preorder, s1 + leftSize + 1, e1, postorder, postRootIdx + 1, e2, map);
        return root;
    }

    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
        int[] postorder = { 4, 5, 2, 6, 7, 3, 1 };

        TreeNode root = constructFromPrePost(preorder, postorder);
        preorderTraversal(root);
    }
}
