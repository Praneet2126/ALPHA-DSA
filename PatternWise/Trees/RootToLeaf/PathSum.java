package PatternWise.Trees.RootToLeaf;

public class PathSum {
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

    public static boolean solution(TreeNode root, int sum ,int targetSum) {
        if(root == null)  {
            return false;
        }

        sum += root.val;
        if(root.left == null || root.right == null) {
            return root.val == targetSum;
        }

        return solution(root.left, sum, targetSum) || solution(root.right, sum, targetSum);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return solution(root, 0, targetSum);
    }

    public static void main(String[] args) {
        
    }
}
