
// DFS 
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int V = isConnected.length;
        
        boolean[] visited = new boolean[V];
        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                provinces++;
                dfs(isConnected, u, visited);
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, int u, boolean[] visited) {
        visited[u] = true;
        for (int v = 0; v < isConnected[u].length; v++) {
            if (isConnected[u][v] == 1 && !visited[v]) {
                dfs(isConnected, v, visited);
            }
        }
        
    }
}

// BFS

/* 
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces= 0;
        int V = isConnected[0].length;

        boolean[] visited = new boolean[V];
        Queue<Integer> que = new LinkedList<>();

        for(int u =0;u < V;u++){
            if(!visited[u]){
                provinces++;
                que.offer(u);
                while(!que.isEmpty()){
                    int node = que.poll();
                    visited[node] = true;
                    for(int v=0; v<V ; v++){
                        if(isConnected[node][v] == 1 && !visited[v]){
                            que.offer(v);
                        }
                    }
                }
            }
        }
        return provinces;
    }
}

*/
