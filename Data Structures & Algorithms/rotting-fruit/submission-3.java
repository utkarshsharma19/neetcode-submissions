class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int fresh   =  0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]== 1) {
                    fresh++;
                }

                if(grid[i][j]== 2) {
                    q.offer(new int [] {i,j});
                }
            }
        }

        while(fresh > 0 && !q.isEmpty()) {
            int len = q.size();
            while(len-- > 0) {
                int [] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                for(int [] dir: directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if (nr >= 0 && nr < grid.length &&
                        nc >= 0 && nc < grid[0].length &&
                        grid[nr][nc] == 1) {
                            grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        fresh--;
                        }
                }
            }
                    time++;
        }
    return fresh == 0 ? time:-1;

    }

}
