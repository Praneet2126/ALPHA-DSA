package PatternWise.Graphs.Bipartite;

import java.util.*;

public class Bipartite {
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
            int src = i;
            for(int j=0; j<edges[i].length; j++) {
                graph[src].add(new Edge(src, edges[i][j]));
            }
        }
    }
    
    public static boolean bfs(ArrayList<Edge>[] graph) {
        int[] col = new int[graph.length];

        Arrays.fill(col, -1);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++) {
            if(col[i] == -1) {
                q.add(i);
                col[i] = 0;
                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if(col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if(col[curr] == col[e.dest]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public boolean isBipartite(int[][] edges) {
        ArrayList<Edge>[] graph = new ArrayList[edges.length];   
        createGraph(graph, edges);

        return bfs(graph);
    }
}
