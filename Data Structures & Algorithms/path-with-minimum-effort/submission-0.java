class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dist = new int[rows][cols];
        for(int [] row: dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, 0, 0}); 
        int [][] directions = {{0,1}, {1,0}, {0, -1 },{-1,0}};

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            int diff = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r == rows - 1 && c == cols - 1) {
                return diff;
            }

            if (dist[r][c] < diff) continue;

            for(int [] dir: directions) {
                int nr = dir[0] + r;
                int nc = dir[1] + c;

                if(nr < 0 || nc < 0|| nr >= rows || nc >= cols) {
                    continue;
                }

                int newDiff = Math.max(diff, Math.abs(heights[r][c] - heights[nr][nc]));

                if(newDiff < dist[nr][nc]) {
                    dist[nr][nc] = newDiff;
                    minHeap.offer(new int[]{newDiff, nr, nc});
                }
            }
        }
    return 0;
        }
}