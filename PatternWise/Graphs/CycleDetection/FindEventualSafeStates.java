package PatternWise.Graphs.CycleDetection;

import java.util.*;

public class FindEventualSafeStates {
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
                graph[i].add(new Edge(i, edges[i][j]));
            }
        }
    }

    public static List<Integer> findTerminalNodes(ArrayList<Edge>[] graph) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<graph.length; i++) {
            if(graph[i].size() == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean[] vis, List<Integer> terminals, boolean[] safeNodes) {
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                dfsUtil(graph, vis, i, terminals, safeNodes);
            }
        }
    }

    public static boolean dfsUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, List<Integer> terminals, boolean[] safeNodes) {
        vis[curr] = true;
        safeNodes[curr] = true;

        for (Edge e : graph[curr]) {
            if (!vis[e.dest] && dfsUtil(graph, vis, e.dest, terminals, safeNodes)) {
                return true;
            } else if(safeNodes[e.dest]){
                return true;
            }
        }

        safeNodes[curr] = false;
        return false;
    }

    @SuppressWarnings("unchecked")
    public static List<Integer> eventualSafeNodes(int[][] edges) {
        ArrayList<Edge>[] graph = new ArrayList[edges.length];
        createGraph(graph, edges);
        
        List<Integer> terminals = findTerminalNodes(graph);
        boolean[] vis = new boolean[graph.length];
        boolean[] safeNodes = new boolean[graph.length];

        dfs(graph, vis, terminals, safeNodes);

        List<Integer> safe = new ArrayList<>();
        for(int i=0; i<safeNodes.length; i++) {
            if(!safeNodes[i]) {
                safe.add(i);
            }
        }

        return safe;
    }
    
    public static void main(String[] args) {
        
    }
}
