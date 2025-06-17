package Graphs;

import java.util.*;

public class CycleDetectionBFS {
    static class Edge {
        int src;
        int dest;
        
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(graph, vis, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Pair {
        int n;
        int par;

        public Pair(int n, int par) {
            this.n = n;
            this.par = par;
        }
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int src) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(src, -1));
        while(!q.isEmpty()) {
            Pair curr = q.remove();
            vis[curr.n] = true;

            for(int i=0; i<graph[curr.n].size(); i++) {
                Edge e = graph[curr.n].get(i);
                if(!vis[e.dest]) {
                    q.add(new Pair(e.dest, curr.n));
                } 
                else if(vis[e.dest] && e.dest != curr.par) {
                    return true;
                }
            }
        }

        return false;
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println(isCycle(graph));
    }
}
