import java.util.*;

public class learning {
   public static void main(String[] args) {
      List<Integer> ll = new LinkedList<>();

      ll.addLast(3);
      ll.addFirst(2);
      ll.addFirst(1);

      for(int i=0; i<ll.size(); i++) {
        System.out.print(ll.get(i)+"->");  
      }
      System.out.println("null");
  }
} 