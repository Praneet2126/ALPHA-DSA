package PatternWise.Trees.MirrorSymmetry;

public class FlipEquivalent {
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
    
    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return root1 == null && root2 == null;
        }

        if(root1.val != root2.val) {
            return false;
        }

        boolean withoutFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        return withoutFlip || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }
}
