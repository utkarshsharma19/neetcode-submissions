class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
     private int find(int p) {
        int cur = p;
        if(parent[p] != p) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    private boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ) {
            return false;
        }

        if(rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if(rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
    return true;
    }
}

class Solution {

    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int res = n;

        for(int [] edge: edges) {
            if(dsu.union(edge[0], edge[1])) {
                res--;
            }
        }
        return res;
    }
}
