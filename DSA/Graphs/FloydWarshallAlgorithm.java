package Graphs;

public class FloydWarshallAlgorithm {
    final static int INF = 99999;
    final static int V = 4;

    public static void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];

        for(int i=0; i<dist.length; i++) {
            for(int j=0; j<dist[0].length; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for(int k=0; k<V; k++) {
            for(int i=0; i<V; i++) {
                for(int j=0; j<V; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // print
        for(int i=0; i<dist.length; i++) {
            for(int j=0; j<dist[0].length; j++) {
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = {{0,3,INF,5},
                         {2,0,INF,4},
                         {INF,1,0,INF},
                         {INF,INF,2,0}};    
        
        floydWarshall(graph);                        
    }
}
