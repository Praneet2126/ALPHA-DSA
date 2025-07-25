package PatternWise.LinkedList.InPlaceReversal;

public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        // Step-1: Find Mid
        ListNode midNode = findMid(head);

        //Step-2: Reverse 2nd half
        ListNode prev = null;
        ListNode curr = midNode;
        ListNode next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode right = prev;  // Right half head
        ListNode left = head;

        ListNode leftPrev = null;
        ListNode rightPrev = null;
        while(right != null ) {
            if(right == null || right.next == null) {
                break;
            }

            leftPrev = left;
            left = left.next;
            leftPrev.next = right;

            rightPrev = right;
            right = right.next;
            rightPrev.next = left;
        }

        return;
    }
}
