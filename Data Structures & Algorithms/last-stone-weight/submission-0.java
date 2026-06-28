class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int nums:stones) {
            pq.offer(-nums);
        }

        while(pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            if(second > first) {
                pq.offer(first - second);
            }
        }
        pq.offer(0);
        return Math.abs(pq.peek());
    }
}
