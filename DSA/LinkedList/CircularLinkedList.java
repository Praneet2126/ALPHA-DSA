package LinkedList;

public class CircularLinkedList {
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            tail.next = head;
            return;
        } 

        newNode.next = head;
        tail.next = newNode;
        head = newNode;
        return;
    }

    public void display() {
        if(head == null) {
            System.out.println("CLL empty");
            return;
        }

        Node first = head;
        Node p = head;
        while(p.next != first) {
            System.out.print(p.data+"->");
            p = p.next;
        }
        System.out.print(p.data+"->");
        System.out.println(p.next.data);
    }
    
    public static void main(String[] args) {
        CircularLinkedList ll = new CircularLinkedList();
        
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        ll.display();
    }
}
