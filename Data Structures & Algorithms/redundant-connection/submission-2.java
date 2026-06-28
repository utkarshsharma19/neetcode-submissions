class DSU {
    int [] parent;
    int [] rank;
    public DSU(int n) {
        
        
    }

    
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int [] parent = new int[edges.length + 1];
        int [] rank = new int[edges.length + 1];

        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for(int [] edge: edges) {
            if(!union(parent, rank, edge[0], edge[1])) {
                return new int[] {edge[0], edge[1]};
            }
        }
        return new int[0];
    }

    public boolean union(int [] parent, int [] rank, int n1, int n2) {
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);

        if(p1 == p2) {
            return false;
        }

        if(rank[p1] > rank[p2]) {
            parent[p2] = p1;
        } else if(rank[p2] > rank[p1]) {
            parent[p1] = p2;
        } else {
            parent[p2] = p1;
            rank[p1]++;
        }
    return true;
    }

    public int find(int p, int[] parent) {
        if(parent[p] != p) {
            parent[p] = find(parent[p], parent);
        }

        return parent[p];
    }
}
