package PatternWise.Trees.RootToLeaf;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
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

    public static void solution(TreeNode root, int sum, int targetSum, List<Integer> temp, List<List<Integer>> list) {
        if(root == null) {
            return;
        }

        temp.add(root.val);
        sum += root.val;

        if(root.left == null && root.right == null) {
            if(sum == targetSum) {
                list.add(new ArrayList<>(temp));
                return;
            }
        } else {
            solution(root.left, sum, targetSum, temp, list);
            solution(root.right, sum, targetSum, temp, list);
        }
        
        temp.remove(temp.size() - 1);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solution(root, 0, targetSum, temp, list);
        return list;
    }

    public static void main(String[] args) {
        
    }
}
