package PatternWise.Graphs.ConnectedComponents;

import java.util.ArrayList;

public class NumberOfProvinces {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int[][] edges) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++) {
            for(int j=0; j<edges[i].length; j++) {
                if(edges[i][j] == 1 && i != j) {
                    graph[i].add(new Edge(i, j));
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public int findCircleNum(int[][] isConnected) {
        ArrayList<Edge>[] graph = new ArrayList[isConnected.length];
        createGraph(graph, isConnected);
        
        int count = 0;
        boolean[] vis = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                dfs(graph, i, vis);
                count++;
            }
        }
        return count;
    }

}
