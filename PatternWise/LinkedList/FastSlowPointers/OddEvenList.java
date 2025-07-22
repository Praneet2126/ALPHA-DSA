package PatternWise.LinkedList.FastSlowPointers;

public class OddEvenList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        // handle base cases
        if(head == null || head.next == null || head.next.next == null) return head;

        ListNode set = head.next;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        int count = 0;
        while(next != null) {
            prev.next = next;
            prev = curr;
            curr = next;
            next = next.next;
            count++;
        }

        prev.next = null;

        if(count % 2 != 0) {
            curr.next = set;
        } else {
            prev.next = set;
        }

        return head;
    }
}
