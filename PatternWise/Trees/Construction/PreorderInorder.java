package PatternWise.Trees.Construction;

import java.util.*;

public class PreorderInorder {
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

    // NOTE: Method 1
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }

        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, mid + 1),
                Arrays.copyOfRange(inorder, 0, mid));

        root.right = buildTree(
                Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                Arrays.copyOfRange(inorder, mid + 1, inorder.length));

        return root;
    }

    // NOTE: Method 2 - > Optimal with HashMap
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    public static TreeNode build(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2, Map<Integer, Integer> map) {
        if(s1 > e1 || s2 > e2) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[s1]);
        int inRootIdx = map.get(preorder[s1]);
        int leftSize = inRootIdx - s2;

        root.left = build(preorder, s1+1, s1+leftSize, inorder, s2, inRootIdx-1, map);
        root.right = build(preorder, s1+leftSize+1, e1, inorder, inRootIdx+1, e2, map);
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
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        TreeNode root = buildTree2(preorder, inorder);
        preorderTraversal(root);
    }
}
