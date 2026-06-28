class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int [] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        for(int i = 0; i <=k; i++) {
            int[] temp = Arrays.copyOf(dist, n);
            for(int [] edge: flights) {
                int u = edge[0];
                int v = edge[1];
                int t = edge[2];
                if(dist[u] == Integer.MAX_VALUE) {
                    continue;
                }
                if (dist[u] + t < temp[v]) {
                    temp[v] = dist[u] + t;
                }
            }
            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
