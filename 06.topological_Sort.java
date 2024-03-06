
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> stack = new Stack<>();
        //visited array
        boolean[] visited = new boolean[V];
        Arrays.fill(visited,false);
        
        // iterate to each node , even its a separate graph 
        
        for(int i =0;i<V;i++){
            if(!visited[i] ){
                topologicalSort(i,visited,adj,stack);
            }
        }
        int[] ans = new int[V];
        int ind = -1;
         while (!stack.isEmpty()) 
        {
            //pushing elements of stack in list and popping them from stack.
            ans[++ind] = stack.peek(); 
            stack.pop();
        }
        return ans;
    }
    static void topologicalSort(int u,boolean[] visited,ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack){
        visited[u] = true;
        // Integer i;
        // Iterator<Integer> it = adj.get(u).iterator();
        
        // while(it.hasNext()){
        //     i = it.next();
        //     if(!visited[i]){
        //         topologicalSort(i,visited,adj,stack);
        //     }
        // }
        //        stack.push(new Integer(u);

        for(int i =0;i<adj.get(u).size();i++){
            //if any vertex is not visited call function recursivly
            if(!visited[adj.get(u).get(i)]){
                topologicalSort(adj.get(u).get(i),visited,adj,stack);
            }
        }
        stack.push(u);
        
    }
}
