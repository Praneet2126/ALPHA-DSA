package Graphs;

import java.util.*;

public class BellmanFordAlgorithm {
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

    public static void createGraph(ArrayList<Edge>[] graph, int edges[][]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            graph[u].add(new Edge(u, v, w));
        }
    }
    
    public static void createGraph2(ArrayList<Edge> graph, int edges[][]) {
        for(int i=0; i<edges.length; i++) {
            graph.add(new Edge(edges[i][0], edges[i][1], edges[i][2]));
        }
    }

    //NOTE: Time: O(V*E)
    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {  
        int dist[] = new int[graph.length-1];
        for(int i=0; i<dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        // O(V)
        for(int i=0; i<V-1; i++) {  // Running for V-1 times
            //edges -> O(E)
            for(int j=0; j<graph.length; j++) {
                for(int k=0; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    //relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        //print
        for(int i=0; i<dist.length; i++) {
            System.out.println(i+"->"+dist[i]);
        }
    }

    //NOTE: O(V*E) -> Same Time, but easier way to code since vertices are not required
    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V) {  
        int dist[] = new int[V];
        for(int i=0; i<dist.length; i++) {
             if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // O(V)
        for(int i=0; i<V-1; i++) {  // Running for V-1 times
            //edges -> O(E)
            for(int j=0; j<graph.size(); j++) {
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                //relaxation
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        //print
        for(int i=0; i<dist.length; i++) {
            System.out.println(i+"->"+dist[i]);
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int edges[][] = {{0,1,2},{0,2,4},{1,2,-4},{2,3,2},{3,4,4},{4,1,-1}};  // directed

        ArrayList<Edge>[] graph = new ArrayList[edges.length];
        createGraph(graph, edges);

        bellmanFord(graph, 0);
    }
}
