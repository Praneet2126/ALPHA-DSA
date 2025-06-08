package Heaps;

import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String[] args) {
        int arr[] = {2,3,3,4,6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++) {
            pq.add(arr[i]);
        }
        
        int cost = 0;

        while(pq.size() > 1) {
            int val1 = pq.remove();
            int val2 = pq.remove();
            cost += val1 + val2;
            pq.add(val1+val2);
        }

        System.out.println(cost);
    }
}
