package Heaps;
import java.util.*;

public class NearbyCars {
    static class Coordinate implements Comparable<Coordinate>{
        int x;
        int y;
        int distSq;
        int idx;

        public Coordinate(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Coordinate c2) {
            return this.distSq - c2.distSq;
        }
    }

    public static void main(String[] args) {
        int points[][] = {{3,3}, {5,-1}, {-2,4}};
        int k = 2;

        PriorityQueue<Coordinate> pq = new PriorityQueue<>();
        for(int i=0; i<points.length; i++) {
            int distSq = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.add(new Coordinate(points[i][0], points[i][1], distSq, i));
        }

        for(int i=0; i<k; i++) {
            System.out.println("C"+pq.remove().idx);
        }
    }
}
