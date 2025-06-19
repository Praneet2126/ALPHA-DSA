package Graphs;

import java.util.*;

public class ConnectingCities {
    static class Edge {
        int src; 
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int cities[][]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<cities.length; i++) {
            for(int j=0; j<cities.length; j++) {
                int src = i;
                int dest = j;
                int wt = cities[i][j];

                if(wt != 0) {
                    graph[i].add(new Edge(src, dest, wt));
                }
            }
        }
    }

    static class Pair implements Comparable<Pair>{
        int v;
        int c;

        public Pair(int v, int c) {
            this.v = v;
            this.c = c;
        }

        public int compareTo(Pair p2) {
            return this.c - p2.c;
        }
    }

    public static int connectingCities(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int finalCost = 0;
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.c;

                for(int i=0; i<graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        return finalCost;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int cities[][] = {{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};

        ArrayList<Edge>[] graph = new ArrayList[cities.length];
        createGraph(graph, cities);

        System.out.println(connectingCities(graph));
    }
}
