package PatternWise.LinkedList.RecursiveTechnique;

public class FlattenDoublyLinkedList {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
            this.child = null;
        }
    };

    public static Node newHead = null;
    public static Node tail = null;

    public static void insertEnd(int val) {
        Node temp = new Node(val);
        temp.next = null;
        temp.prev = null;
        temp.child = null;

        if(newHead == null) {
            newHead = tail = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    public static void dfs(Node head) {
        if(head == null) {
            return;
        }

        insertEnd(head.val);
        if(head.child != null) {
            dfs(head.child);
        }

        if(head.next != null) {
            dfs(head.next);
        }
    }

    public Node flatten(Node head) {
        newHead = null;
        tail = null;
        dfs(head);
        return newHead;
    }
}
