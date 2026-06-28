class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int [] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int preq[]: prerequisites) {
            adj.get(preq[1]).add(preq[0]);
            indegree[preq[0]]++;
        }

        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int finish = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            finish++;
            for(int nei: adj.get(node)) {
                indegree[nei]--;
                if(indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
        return finish == numCourses ? true : false;
    }
}
