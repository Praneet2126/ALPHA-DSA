package Heaps;

import java.util.PriorityQueue;

public class Questions {
    public static int minTimeToFillSlot(int N, int K, int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[N+1];
        int time = 0;

        for(int i=0; i<arr.length; i++) {
            visited[arr[i]] = true;
            pq.add(arr[i]);

            if(arr[i]-1 > 1 && visited[arr[i]-1] == false) {
                pq.add(arr[i]-1);
            }

            if(arr[i]+1 <= N && visited[arr[i]+1] == false) {
                pq.add(arr[i]+1);
            }

            if(pq.size() > N) {
                return time;
            } else {
                time++;
            }
        }

        return time;
    }
    
    public static void main(String[] args) {
        
    }
}
