class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];


        for(var u : prerequisites){    
            int course = u[0];
            int prereq = u[1];
            adj.get(prereq).add(course);   
            indegree[course]++;
        }


        Queue<Integer> que = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indegree[i] ==0){
                que.offer(i);
            }
        }
        List<Integer> result = new LinkedList<>();
        while(!que.isEmpty()){
            int course= que.poll();
            result.add(course);
            for(int nextCourse : adj.get(course)){
                if(--indegree[nextCourse] == 0)
                    que.add(nextCourse);
            }
        }

        if (result.size() == n) return true;
        else return false;
    }



    
}


/*
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create an adjacency list to represent graph 
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());

        }
        //fill the adh list with prereq
        for(int[] u : prerequisites){
            adj.get(u[1]).add(u[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        //DFS on each forest
        for(int i =0;i<numCourses;i++){
            if(!visited[i] && hasCycle(i,adj,visited,stack)){
                return false;
            }
        }
        return true;

    }
    private boolean hasCycle(int v, List<List<Integer>> adj,boolean[] visited,boolean[] stack){
        //if node in stack cycle detected
        if(stack[v]){
            return true;
        }
        //if node is already visited ,no cycle
        if(visited[v]){
            return false;
        }
        
        visited[v] = true;
        stack[v] = true;

        //check neighbours for cycle
        for(int neighbour : adj.get(v)){
            if(hasCycle(neighbour,adj,visited,stack)){
                return true;
            }
        }
        stack[v] = false;
        return false;
    }
}

*/
