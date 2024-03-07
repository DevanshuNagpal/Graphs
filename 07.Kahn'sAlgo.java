class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] indegree = new int[V];
        for(List<Integer> u : adj){
            for(int v : u ){
                indegree[v]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        
        for(int i =0;i<V;i++){
            if(indegree[i] ==0){
                que.offer(i);
            }
        }
        List<Integer> result = new LinkedList<>();
        while(!que.isEmpty()){
            int node = q.poll();
            result.add(node);
            for(int v : adj.get(node)){
                indegree[v]--;
                if(indegree[v] == 0){
                    que.add(v);
                }
            }
        }
        int[] ans = new int[V];
        
        for( int i =0; i<V;i++){
            ans[i] =result.get(i);
        }
        return ans;
    }
}prog.java:82: error: cannot find symbol
            int node = q.poll();
                       ^
  symbol:   variable q
  location: class Solution
1 error
