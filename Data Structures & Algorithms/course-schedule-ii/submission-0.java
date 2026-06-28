class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        int [] indegree = new int[numCourses];
        int finish = 0;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int [] preq: prerequisites) {
            adj.get(preq[1]).add(preq[0]);
            indegree[preq[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.add(i); //no prereq courses
            }
        }

        while(!q.isEmpty()) {
            int node  = q.poll();
            finish++;
            result.add(node);
            for(int nei: adj.get(node)) {
                indegree[nei]--;
               if(indegree[nei] == 0) {
                q.add(nei);
               } 
            }
        }

        if(finish != numCourses) {
            return new int [] {};
        }

         int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
