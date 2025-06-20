package Graphs;

import java.util.*;

public class ArticulationPoint {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int edges[][]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            graph[src].add(new Edge(src, dest));
            graph[dest].add(new Edge(dest, src));
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int dt[], int low[], int time, boolean vis[], boolean ap[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e= graph[curr].get(i);
            int neigh = e.dest;

            if(par == neigh) {
                continue;
            } else if(vis[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                dfs(graph, e.dest, curr, dt, low, time, vis, ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(par != -1 && dt[curr] <= low[neigh]) {
                    ap[curr] = true; // AP
                }
                children++;
            }
        }
        if(par == -1 && children > 1) {
            ap[curr] = true;  // AP
        }
    }

    public static void getAP(ArrayList<Edge>[] graph, int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean vis[] = new boolean[V];
        int time = 0;
        boolean ap[] = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                dfs(graph, i, -1, dt, low, time, vis,ap);
            }
        }
        
        for(int i=0; i<V; i++) {
            if(ap[i]) {
                System.out.println("AP: "+i);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5;
        int edges[][] = {{0,1},{0,2},{0,3},{1,2},{3,4}};
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, edges);

        getAP(graph, V);
    }
}
