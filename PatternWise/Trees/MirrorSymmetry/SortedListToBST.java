package PatternWise.Trees.MirrorSymmetry;

public class SortedListToBST {
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

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // NOTE: Method 1
    static class Pair {
        ListNode prev;
        ListNode slow;

        public Pair(ListNode prev, ListNode slow) {
            this.prev = prev;
            this.slow = slow;
        }
    }

    public static Pair findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return new Pair(prev, slow);
    }

    public static TreeNode toBST(ListNode head, ListNode tail) {
        if(head == null || tail == null) {
            return null;
        }

        Pair mid = findMid(head);

        TreeNode root = new TreeNode(mid.slow.val);

        // Break the list
        if(mid.prev != null) {
            mid.prev.next = null;
        }

        root.left = toBST(head, mid.prev);
        root.right = toBST(mid.slow.next, tail);
        return root;
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return new TreeNode(head.val);
        }
        
        ListNode curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }

        return toBST(head, curr);
    }

    public static void preorder(TreeNode root) {
        if(root == null) {
            return;
        }

        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }

    // NOTE: Method 2 -> O(n)
    public static TreeNode sortedListToBST2(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);

        ListNode slow=head,fast=head,slow_Prev=null;
        while(fast!=null && fast.next!=null){
            slow_Prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        slow_Prev.next = null;
        root.left = sortedListToBST2(head);
        root.right = sortedListToBST2(slow.next);
        return root;
    } 

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = sortedListToBST(head);
        preorder(root);
    }
}
