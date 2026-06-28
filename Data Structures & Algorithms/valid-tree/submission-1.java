class Solution {
    private int[] parent;
    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;
        parent = new int [n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int [] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            if(!union(u, v)) {
                return false;
            }
        }
        return true;
    }

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot == yRoot) {
            return false;
        }

        parent[xRoot] = yRoot;

        return true;

    }
}


//union and find