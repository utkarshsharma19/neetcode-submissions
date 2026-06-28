class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time : times) {
            edges.computeIfAbsent(time[0],
            key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] - b[0]);
        int t = 0;
        pq.offer(new int[]{0,k}); //time and node
        Set<Integer> visited = new HashSet<>();
        while(!pq.isEmpty()) {
            int []curr = pq.poll();
            int time = curr[0];
            int n1 = curr[1];
            if(visited.contains(n1)) {
                continue;
            }

            visited.add(n1);
            t = time;

            if(edges.containsKey(n1)) {
                for(int [] next: edges.get(n1)) {
                    int n2 = next[0];
                    int w2 = next[1];

                    if(!visited.contains(n2)) {
                        pq.offer(new int[] {time + w2, n2});
                    }
                }
            }
        }
    return visited.size() == n ? t : -1;
    }
}
