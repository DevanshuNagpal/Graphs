class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
class Solution {
    private boolean isCycle_BFS(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Pair<Integer,Integer>> que = new LinkedList<>();
        que.offer(new Pair<>(u,-1));
        visited[u] =  true;
        while(!que.isEmpty()){
            int Node = que.peek().getKey();
            int parent = que.peek().getValue();
            que.poll();
            
            for(int v: adj.get(Node)){
                if(!visited[v]){
                    visited[v] = true;
                    que.offer(new Pair<>(v,Node));
                    
                }
                else if(v != parent) return true;
            }
            
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        //graph might be in segments
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                Arrays.fill(visited, false);
                if (isCycle_BFS(i, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
