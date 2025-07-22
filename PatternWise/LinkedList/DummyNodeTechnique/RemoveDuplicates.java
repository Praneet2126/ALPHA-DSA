package PatternWise.LinkedList.DummyNodeTechnique;

public class RemoveDuplicates {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        
        if(head == null) {
            return head;
        }

        while(temp.next != null) {
            if(temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
