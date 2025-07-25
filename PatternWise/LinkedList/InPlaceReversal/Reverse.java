package PatternWise.LinkedList.InPlaceReversal;

public class Reverse {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } 

        head = prev;
        return head;
    }

    public static void main(String[] args) {
        
    }
}
