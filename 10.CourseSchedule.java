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
