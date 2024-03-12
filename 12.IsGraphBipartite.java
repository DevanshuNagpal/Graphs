class Solution {
    private boolean checkBipartite(int[][] graph, int curr, int[] color, int currColor) {
        color[curr] = currColor;

        for (int v : graph[curr]) {
            if (color[v] == color[curr]) {
                return false;
            }
            if (color[v] == -1) {
                color[v] = 1 - currColor;
                if (!checkBipartite(graph, v, color, color[v])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!checkBipartite(graph, i, color, 1)) {
                    return false;
                }
            }
        }

        return true;
    }
}
