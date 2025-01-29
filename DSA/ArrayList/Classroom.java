package ArrayList;

import java.util.ArrayList;

public class Classroom {
    public static int maxElement(ArrayList<Integer> list) {
        int max = 0;
        for(int i : list) {
            max = i > max ? i : max;
        }
        return max;
    }

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // ArrayList<Integer> list2 = new ArrayList<>();
        // ArrayList<Integer> list3 = new ArrayList<>();

        list.add(1); 
        list.add(2); 
        list.add(3); 
        list.add(4);
        
        System.out.println(list);

        int idx = list.get(3);
        System.out.println(idx);

        list.set(2, 7);
        System.out.println(list);

        System.out.println(list.contains(8));

        list.add(2, 8);
        System.out.println(list);

        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        System.out.println(maxElement(list));

        swap(list, 1, 4);
        System.out.println(list);
    }
}
