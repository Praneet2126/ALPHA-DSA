package PatternWise.Graphs.CycleDetection;

import java.util.*;

public class CourseScheduleII {
    static class Edge {
        int src, dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int[][] prerequisites) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<prerequisites.length; i++) {
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            graph[src].add(new Edge(src, dest));
        }
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(detectCycleUtil(graph, vis, stack, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, boolean[] stack, int curr) {
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) {
                return true;
            }

            if(!vis[e.dest]) {
                if(detectCycleUtil(graph, vis, stack, e.dest)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    public static Stack<Integer> topoSort(ArrayList<Edge>[] graph) {
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topoSortUtil(graph, vis, i, s);
            }
        }
        return s;
    }

    public static void topoSortUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, Stack<Integer> s) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topoSortUtil(graph, vis, e.dest, s);
            }
        }
        s.push(curr);
    }

    @SuppressWarnings("unchecked")
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Edge>[] graph = new ArrayList[numCourses];
        createGraph(graph, prerequisites);

        int[] res = new int[numCourses];
        int k = 0;

        if(detectCycle(graph)) {
            return new int[0];
        } else {
            Stack<Integer> s = topoSort(graph);
            while(!s.isEmpty()) {
                res[k++] = s.peek();
                s.pop();
            }
        }
        return res;
    }
}
