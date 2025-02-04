package LinkedList;

public class LinkedList {
    // Node Class
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // O(1)
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // O(1)
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // O(n)
    public void addAtIndex(int index, int data) {
        if(index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        
        Node temp = head;
        int i = 0;
        while(i < index-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // O(1)
    public int removeFirst() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = tail.data;
            head = tail = null;
            size = 0;
            return val;
        }
        
        Node prev = head;
        while (prev.next != tail) {
            prev = prev.next;
        }

        int val = tail.data;
        size--;
        tail = prev;
        prev.next = null;
        return val;
    }

    public void display() {
        if(head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        
        Node p = head;
        while(p != null) {
            System.out.print(p.data+" -> ");
            p = p.next;
        }
        System.out.println("null");
    }

    // O(n)
    public int iterativeSearch(int key) {
        if(head == null) {
            return -1;
        }

        Node temp = head;
        int i = 0;
        while(temp != null) {
            if(temp.data == key) {
                return i;
            } 
            temp = temp.next;
            i++;
        }

        return -1;
    }

    public int helper(Node head, int key) {
        if(head == null) {
            return -1;
        }

        if(head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1) {
            return -1;
        } else {
            return idx+1;
        }
    }

    public int recursiveSearch(int key) {       // Time = O(n) and Space = O(n)
        return helper(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
        }

        head = prev;
    }

    public void deleteNthNodeFromEnd(int n) {
        if(n == size) {
            head = head.next;
            return;
        }
        
        Node prev = head;
        int i = 1;
        while (i < size-n) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    // slow fast appraoch
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean palindrome(Node head) {
        // Edge case
        if(head == null || head.next == null) {
            return true;
        }

        // Step-1: Find Mid
        Node midNode = findMid(head);

        //Step-2: Reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;  // Right half head
        Node left = head;

        // Step-3: Check 
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        // detect
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                cycle = true;
                break;
            }
        }

        // no cycle found
        if(cycle == false) {
            return;
        }

        slow = head;
        Node prev = null;
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }

    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(Integer.MIN_VALUE);    // dummy node
        Node temp = mergedLL;

        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;   // exclude dummy node
    }

    // O(nlogn)
    public Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node midNode = getMid(head);
        Node rightHead = midNode.next;
        midNode.next = null;
        
        Node leftHalf = mergeSort(head);
        Node rightHalf = mergeSort(rightHead);
        return merge(leftHalf, rightHalf);
    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.display();
        head = ll.mergeSort(head);
        ll.display();
    }
}

