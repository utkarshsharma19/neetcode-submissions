class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        dfs(0, adj, visited);

        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        if (visited[node]) return;
        visited[node] = true;

        for (int nei : adj.get(node)) {
            dfs(nei, adj, visited);
        }
    }
}