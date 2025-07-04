package Graphs;

import java.util.*;

public class KruskalsAlgorithm {
    static class Edge implements Comparable<Edge>{
        int src; 
        int dest; 
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    public static void createGraph(ArrayList<Edge> edges) {     // Not an Array of AL
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    } 

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for(int i=0; i<n; i++) {
            par[i] = i;
        }
    } 

    public static int find(int x) {
        if(par[x] == x) return x;
        return par[x] = find(x);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if(rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }
    
    public static void kruskalsMST(ArrayList<Edge> edges, int V) {  // O(V + ElogE)
        init();
        Collections.sort(edges);    // O(ElogE)
        int mstCost = 0;
        int count = 0;

        for(int i=0; count<V-1; i++) {  // O(V)
            Edge e = edges.get(i);

            if(find(e.src) != find(e.dest)) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }

        System.out.println(mstCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);

        kruskalsMST(edges, V);
    }
}
