class Pair {
    int count;
    int readyTime;

    public Pair(int count, int readyTime) {
        this.count = count;
        this.readyTime = readyTime;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int freq [] = new int[26];
        HashMap<Character, Integer> map = new HashMap<>();
        for(char task: tasks) {
            freq[task - 'A']++;
        }
        int time = 0;
        for(int f : freq) {
            if(f > 0) {
                pq.offer(f);
            }
        }

        Queue<Pair> q = new LinkedList<>();
        while(!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if(!pq.isEmpty()) {
                int count = pq.poll() - 1;
                if(count > 0) {
                    q.offer(new Pair(count, time + n));
                }
            }
            if(!q.isEmpty() && q.peek().readyTime <= time) {
                pq.offer(q.poll().count);
            } 
        }

        return time;
    }
}
