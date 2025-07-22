package PatternWise.LinkedList.DummyNodeTechnique;

public class ParitionList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode l1 = null;
        ListNode tail = null;

        ListNode curr = head;
        while(curr != null) {
            if(curr.val < x) {
                ListNode temp = new ListNode(curr.val);
                if(l1 == null) {
                    l1 = tail = temp;
                } else {
                    tail.next = temp;
                    tail = tail.next;
                }
            }
            curr = curr.next;
        }

        curr = head;
        while(curr != null) {
            if(curr.val >= x) {
                ListNode temp = new ListNode(curr.val);
                if(l1 == null) {
                    l1 = tail = temp;
                } else {
                    tail.next = temp;
                    tail = tail.next;
                }
            }
            curr = curr.next;
        }

        return l1;
    }
}
