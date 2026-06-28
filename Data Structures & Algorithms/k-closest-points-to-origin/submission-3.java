class Node {
    int dist;
    int[] point;

    public Node(int dist, int[] point) {
        this.dist = dist;
        this.point = point;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.dist - a.dist);

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int dist = x * x + y * y;

            pq.offer(new Node(dist, point));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll().point;
        }

        return res;
    }
}