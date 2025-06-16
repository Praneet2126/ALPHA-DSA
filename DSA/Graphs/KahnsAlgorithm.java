package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgorithm {
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

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void getIndegree(ArrayList<Edge>[] graph, int indegree[]) {
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }
    }

    public static void topoSort(ArrayList<Edge>[] graph) {
        int indegree[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        
        getIndegree(graph, indegree);

        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        //bfs
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");     // topological sort print

            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;
                if(indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        topoSort(graph);
    }
}