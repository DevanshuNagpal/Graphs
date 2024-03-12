//DFS
class Solution {
    int idx = -1;
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        idx = numCourses - 1;

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] courses = new boolean[numCourses];
        int[] order = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!visited[i] && isCyclic(graph,visited,courses,i)){
                return new int[] {};
            }
        }

        for(int i = 0; i < numCourses; i++){
            if(!courses[i]) {
                topSort(graph,order,courses,i);
            }
        }

        return order;
    }
    private void topSort(ArrayList<Integer>[] graph,int[] order,boolean[] courses,int node){
        if(courses[node]){
            return;
        }

        courses[node] = true;

        for(int i = 0; i < graph[node].size(); i++){
           topSort(graph,order,courses,graph[node].get(i)); 
        }

        order[idx--] = node;

    }
    private boolean isCyclic(ArrayList<Integer>[] graph,boolean[] visited,boolean[] courses,int node) {
        if(courses[node]){
            return true;
        }

        if(visited[node]) {
            return false;
        }

        visited[node] = true;
        courses[node] = true;

        for(int i = 0; i < graph[node].size(); i++){
            if(isCyclic(graph,visited,courses,graph[node].get(i))) {
                courses[node] = false;
                return true;
            }
        }
        courses[node] = false;

        return false;
    }
}


//BFS


class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
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
        if(result.size() !=n) return new int[0];
        
        int [] ans = new int[result.size()];
        for(int i =0;i<result.size();i++){
            ans[i] = result.get(i);
        }
        return ans;

    }
}
