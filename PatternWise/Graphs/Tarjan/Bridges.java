package PatternWise.Graphs.Tarjan;

import java.util.*;

public class Bridges {
    static class Edge {
        int src, dest;
        
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int n, List<List<Integer>> connections) {
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<connections.size(); i++) {
            int src = connections.get(i).get(0);
            int dest = connections.get(i).get(1);
            graph[src].add(new Edge(src, dest));
            graph[dest].add(new Edge(dest, src));
        }
    }

    public static List<List<Integer>> findBridges(ArrayList<Edge>[] graph, int n) {
        boolean[] vis = new boolean[n];
        int[] dt = new int[n];
        int[] low = new int[n];
        int time = 0;
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time, list);
            }
        }

        return list;
    } 

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int[] dt, int[] low, boolean[] vis, int time, List<List<Integer>> list) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if(neigh == par) {
                continue;
            } else if(!vis[neigh]) {
                dfs(graph, neigh, curr, dt, low, vis, time, list);
                low[curr] = Math.min(low[curr], low[neigh]);
                // Bridge Condition
                if(dt[curr] < low[neigh]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(e.src);
                    temp.add(e.dest);
                    list.add(new ArrayList<>(temp));
                } 
            } else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(graph, n, connections);
        return findBridges(graph, n);
    }
    
    public static void main(String[] args) {
        int[][] arr = {{0,1},{1,2},{2,0},{1,3}};
        List<List<Integer>> connections = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            int src = arr[i][0];
            int dest = arr[i][1];
            List<Integer> temp = new ArrayList<>();
            temp.add(src);
            temp.add(dest);

            connections.add(new ArrayList<>(temp));
        }

        System.out.println(criticalConnections(4, connections));
    }
}
