package PatternWise.Trees.Construction;
import java.util.*;

public class SerializeDeserialize {
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
    
    public static String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.remove();
            if(curr == null) {
                sb.append("#,");
            } else {
                sb.append(curr.val+",");
                q.add(curr.left);
                q.add(curr.right);
            }
        }

        return sb.toString();
    }

    public static TreeNode deserialize(String str) {
        if(str.equals("")) {
            return null;
        }

        String[] values = str.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        for(int i=1; i<values.length; i++) {
            TreeNode curr = q.remove();
            if(!values[i].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(values[i]));
                q.add(curr.left);
            }

            i++;
            
            if(!values[i].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                q.add(curr.right);
            }
        }

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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String str = serialize(root);
        System.out.println(str);
        root = deserialize(str);
        preorderTraversal(root);
    }
}
