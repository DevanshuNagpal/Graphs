class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    private void dfs(int u,boolean[] vis,ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj){
        vis[u] = true;
        ans.add(u);
        for(int i = 0;i< adj.get(u).size();i++){
            if(!vis[adj.get(u).get(i)])
                dfs(adj.get(u).get(i),vis,ans,adj);
        }
    }
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        dfs(0,vis,ans,adj);
        return ans;
    }
}
//TC : O(V+E) 
//SC : O(V) -- max space by recursive call 

/*
Input: V = 4, adj = [[1,3], [2,0], [1], [0]]

Output: 0 1 2 3
Explanation:
0 is connected to 1 , 3.
1 is connected to 0, 2. 
2 is connected to 1.
3 is connected to 0. 
so starting from 0, it will go to 1 then 2
then back to 0 then 0 to 3
thus dfs will be 0 1 2 3. 
*/
