package PatternWise.Trees.Construction;

import java.util.*;

public class PostorderInorder {
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

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);
    }

    public static TreeNode build(int[] postorder, int s1, int e1, int[] inorder, int s2, int e2, Map<Integer, Integer> map) {
        if(s1 > e1 || s2 > e2) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[e1]);
        int inRootIdx = map.get(postorder[e1]);
        int leftSize = inRootIdx - s2;

        root.left = build(postorder, s1, s1+leftSize-1, inorder, s2, inRootIdx-1, map);
        root.right = build(postorder, s1+leftSize, e1-1, inorder, inRootIdx+1, e2, map);
        return root;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(postorder, inorder);
        inorderTraversal(root);
    }
}
