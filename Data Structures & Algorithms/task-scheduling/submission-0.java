class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : map.values()) {
            maxHeap.add(freq);
        }

        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;
             if (!maxHeap.isEmpty()) {
                int freq = maxHeap.poll() - 1;
                if (freq > 0) {
                    cooldownQueue.offer(new int[]{freq, time + n});
                }
            }

            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time) {
                maxHeap.offer(cooldownQueue.poll()[0]);
            }
        }
        return time;

    }
}
