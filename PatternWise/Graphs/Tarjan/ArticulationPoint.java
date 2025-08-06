package PatternWise.Graphs.Tarjan;

import java.util.*;

public class ArticulationPoint {
    static class Edge {
        int src, dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int n, ArrayList<ArrayList<Integer>> adj) {
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int u=0; u<adj.size(); u++) {
            for(int v : adj.get(u)) {
                graph[u].add(new Edge(u, v));
            }
        }
    }

    public static ArrayList<Integer> findAP(ArrayList<Edge>[] graph, int n) {
        boolean[] vis = new boolean[n];
        int[] dt = new int[n];
        int[] low = new int[n];
        int[] time = {0};
        boolean[] ap = new boolean[n];
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                dfs(graph, i, -1, vis, dt, low, time, ap);
            }
        }

        for(int i=0; i<ap.length; i++) {
            if(ap[i]) {
                res.add(i);
            }
        }

        return res;
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, boolean[] vis, int[] dt, int[] low, int[] time, boolean[] ap) { 
        vis[curr] = true;
        dt[curr] = low[curr] = ++time[0];
        int children = 0;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if(neigh == par) {
                continue;
            } else if(vis[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                dfs(graph, e.dest, curr, vis, dt, low, time, ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(par != -1 && dt[curr] <= low[neigh]) {
                    ap[curr] = true;
                }
                children++;
            }
        }
        if(par == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V, adj);
        return findAP(graph, V);
    }
    
    public static void main(String[] args) {
        
    }
}
