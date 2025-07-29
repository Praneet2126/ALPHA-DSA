package PatternWise.Trees.RootToLeaf;

public class SumRootToLeaf {
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

    // NOTE: Method 1 -> With Strings
    private static int sum = 0;
    public static void rootToLeaf(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }

        sb.append(root.val);

        if(root.left == null && root.right == null) {
            sum += Integer.parseInt(sb.toString()); 
        } else {
            rootToLeaf(root.left, sb);
            rootToLeaf(root.right, sb);
        }

        sb.deleteCharAt(sb.length()-1);
    }

    public static int sumNumbers(TreeNode root) {
        sum = 0;
        rootToLeaf(root, new StringBuilder(""));
        return sum;
    }

    // NOTE: Method 2: Without strings
    public static int sumNumbers2(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }

        sum = sum * 10 + root.val;

        if(root.left == null && root.right == null) {
            return sum;
        }

        return dfs(root.left, sum) + dfs(root.right, sum);
    }

    public static void main(String[] args) {
        
    }
}
