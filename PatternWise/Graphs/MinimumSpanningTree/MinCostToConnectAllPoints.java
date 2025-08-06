package PatternWise.Graphs.MinimumSpanningTree;

import java.util.*;

public class MinCostToConnectAllPoints {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class DSU {
        int n;
        int[] par;
        int[] rank;

        public DSU(int n) {
            this.n = n;
            this.par = new int[n];
            this.rank = new int[n];

            for(int i=0; i<n; i++) {
                par[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if(x == par[x]) return x;
            return par[x] = find(par[x]);
        }

        public void union(int a, int b) {
            int parA = find(a);
            int parB = find(b);

            if(rank[parA] == rank[parB]) {
                par[parB] = parA;
                rank[parA]++;
            } else if(rank[parA] < rank[parB]) {
                par[parA] = parB;
            } else {
                par[parB] = parA;
            }
        }
    }
    
    public static int manhattenDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void createGraph(ArrayList<Edge> edges, int[][] points) {        
        for(int i=0; i<points.length; i++) {
            for(int j=i+1; j<points.length; j++) {
                int src = i;
                int dest = j;
                int wt = manhattenDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
                edges.add(new Edge(src, dest, wt));
            }
        }
    }

    public static int kruskalsMST(ArrayList<Edge> edges, int V) {
        DSU dsu = new DSU(V);
        Collections.sort(edges, (a,b) -> a.wt - b.wt);
        int mstCost = 0;

        for(int i=0; i<edges.size(); i++) {
            Edge e = edges.get(i);

            if(dsu.find(e.src) != dsu.find(e.dest)) {
                dsu.union(e.src, e.dest);
                mstCost += e.wt;
            }
        }

        return mstCost;
    }

    public int minCostConnectPoints(int[][] points) {
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges, points);
        return kruskalsMST(edges, points.length);
    }
    
    public static void main(String[] args) {
        
    }
}
