class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= edges.length; i++) {
            adj.add(new ArrayList<>());
        }
        HashSet<Integer> hs = new HashSet<>();

        for(int [] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            boolean [] visit = new boolean[edges.length + 1];

        if(dfs(u, -1, adj, visit)) {
            return edge;
        }
        }


        

        return new int [0];
    }

    private boolean dfs(int node, int parent, List<List<Integer>>adj, boolean[] visit) {
        if(visit[node]) {
            return true;
        }

        visit[node] = true;
        for(int nei: adj.get(node)) {
            if(nei == parent) {
                continue;
            }
            if(dfs(nei, node, adj, visit)) {
                return true;
            }
        }

        return false;
     }
}
