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
        int[] freq = new int[26];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair> q = new LinkedList<>();
        for(char task: tasks) {
            freq[task - 'A']++;
        }

       for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }
  int time = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    q.offer(new Pair(cnt, time + n));
                }
            }

            if (!q.isEmpty() && q.peek().readyTime <= time) {
                maxHeap.offer(q.poll().count);
            }
        }

        return time;
    }
}