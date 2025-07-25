package PatternWise.LinkedList.InPlaceReversal;

public class SplitLinkedListInParts {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];

        ListNode curr = head;
        int N = 0;
        while(curr != null) {
            curr = curr.next;
            N++;
        }

        int capacity = N / k;
        int initialBoxes = N % k;

        ListNode prev = null;
        curr = head;
        for(int i=0; i<arr.length; i++) {
            arr[i] = curr;
            int j = 1;
            
            if(i < initialBoxes) {
                while(j < (capacity + 1) && curr != null) {
                    curr = curr.next;
                    j++;
                }
            } else {
                while(j < capacity && curr != null) {
                    curr = curr.next;
                    j++;
                }
            }

            if(curr != null) {
                prev = curr;
                curr = curr.next;
                prev.next = null;
            }
        }
        return arr;
    }
}
