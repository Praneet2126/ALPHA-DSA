package PatternWise.LinkedList.FastSlowPointers;

public class RemoveNthNodeFromLast {
    static class ListNode {
        int val;
        ListNode next;
        
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode curr = head;
        while(curr != null) {
            size++;
            curr = curr.next;
        }

        if(n == size) {
            head = head.next;
            return head;
        }

        curr = head;
        int i = 1;
        while(i < size - n) {
            curr = curr.next;
            i++;
        }

        curr = curr.next.next;
        return head;
    }
    
    public static void main(String[] args) {
        
    }
}
