import java.util.*;

class Solution {
    // Function to detect cycle in an undirected graph using DFS.
    private boolean isCycle_DFS(int v, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[v] = true;

        for (Integer i : adj.get(v)) {
            if (!visited[i]) {
                if (isCycle_DFS(i, v, adj, visited)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }
        }

        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCycle_DFS(i, -1, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(0);
        adj.get(0).add(3);

        if (sol.isCycle(V, adj)) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }
    }
}
