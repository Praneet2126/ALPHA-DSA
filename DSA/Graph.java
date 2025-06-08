// Graph operations in Java
import java.util.*;

class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjList;

    public Graph(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // 1. Create (Add Edge)
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    // 2. Display
    public void display() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adjList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // 3. InDegree
    public int inDegree(int node) {
        int indegree = 0;
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : adjList[i]) {
                if (neighbor == node) {
                    indegree++;
                }
            }
        }
        return indegree;
    }

    // 4. OutDegree
    public int outDegree(int node) {
        return adjList[node].size();
    }

    // 5. Number of Paths from u to v
    public int countPaths(int u, int v) {
        boolean[] visited = new boolean[vertices];
        return countPathsUtil(u, v, visited);
    }

    private int countPathsUtil(int u, int v, boolean[] visited) {
        visited[u] = true;
        if (u == v) {
            visited[u] = false;
            return 1;
        }

        int count = 0;
        for (int neighbor : adjList[u]) {
            if (!visited[neighbor]) {
                count += countPathsUtil(neighbor, v, visited);
            }
        }

        visited[u] = false;
        return count;
    }

    // 6. Traversal

    // BFS (Breadth-First Search)
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");

            for (int neighbor : adjList[curr]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }

    // DFS (Depth-First Search)
    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        System.out.print("DFS Traversal: ");
        while (!stack.isEmpty()) {
            int curr = stack.pop();

            if (!visited[curr]) {
                visited[curr] = true;
                System.out.print(curr + " ");

                // Push neighbors in reverse order to get the correct DFS order
                ListIterator<Integer> it = adjList[curr].listIterator(adjList[curr].size());
                while (it.hasPrevious()) {
                    int neighbor = it.previous();
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.display();

        System.out.println("In-degree of 3: " + g.inDegree(3));
        System.out.println("Out-degree of 0: " + g.outDegree(0));
        System.out.println("Number of paths from 0 to 4: " + g.countPaths(0, 4));

        g.bfs(0);
        g.dfs(0);
    }
}
