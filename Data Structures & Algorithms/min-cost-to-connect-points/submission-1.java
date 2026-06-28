class DSU{
    int[] rank;
    int[] parent;
    public DSU(int n) {
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(rank, 1);
    }

    public int find(int  p) {
        if(parent[p] != p) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    public boolean union(int p, int q) {
        
        int rootP = find(p);
        int rootQ = find(q);
    if(rootP == rootQ) {
        return false;
    }
        if(rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else if( rank[rootQ] > rank[rootP]) {
            parent[rootP] = rootQ;
        } else {
              parent[rootQ] = rootP; //whoever is the parent gets their rank increased
              rank[rootP]++;
        }
        return true;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) 
                         + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{cost, i, j});
            }
        }

        edges.sort((a, b) -> a[0] - b[0]);
            DSU dsu = new DSU(n);
                int totalCost = 0;
        int edgesUsed = 0;
         for (int[] edge : edges) {
            int cost = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (dsu.union(u, v)) {
                totalCost += cost;
                edgesUsed++;

                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        return totalCost;
    }
}
