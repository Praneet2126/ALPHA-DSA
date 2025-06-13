package LinkedList;

public class IntersectionOfLists {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static Node intersection(Node head1, Node head2) {
        int size1 = 0;
        int size2 = 0;

        Node curr = head1;
        while(curr != null) {
            size1++;
            curr = curr.next;
        }

        curr = head2;
        while(curr != null) {
            size2++;
            curr = curr.next;
        }

        Node temp1, temp2;
        if(size1 > size2) {
            temp1 = head1;
            temp2 = head2;
        } else {
            temp1 = head2;
            temp2 = head1;
        }

        int i=0;
        while(i < Math.abs(size1 - size2)) {
            temp1 = temp1.next;
            i++; 
        }

        while(temp1 != null) {
            if(temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    } 
    
    public static void main(String[] args) {
        
    }
}
