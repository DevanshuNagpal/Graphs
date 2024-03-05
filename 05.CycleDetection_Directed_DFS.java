class Solution {
    private boolean isCycle_DFS(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v] && isCycle_DFS(adj, v, visited, inRecursion)) {
                return true;
            } else if (inRecursion[v]) {
                return true;
            }

        }
        inRecursion[u] = false;
        return false;
    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        boolean[] inRecursion = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (isCycle_DFS(adj, i, visited, inRecursion)) {
                    return true;
                }
            }

        }
        return false;
    }
}
