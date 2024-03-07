class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] indegree = new int[V];
        for(List<Integer> u : adj){
            for(int v: u){
                indegree[v]++;
            }
        }
        
        Queue<Integer> que = new LinkedList<>();
        for(int i =0 ;i<V;i++){
            if(indegree[i] == 0){
                que.offer(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!que.isEmpty()){
            int node = que.poll();
            result.add(node);
            for(int v : adj.get(node)){
                indegree[v]--;
                if(indegree[v] == 0){
                    que.add(v);
                }
            }
        }
        if(result.size() == V){
            return false;
        }
        else return true;
    }
}
