public class Pair{
    int distance;
    int [] point;
    public Pair(int distance, int [] point) {
        this.distance = distance;
        this.point = point;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.distance - a.distance);
        for(int [] point: points) {
            int x = point[0];
            int y = point[1];

            int dist = x * x + y * y;

            pq.offer(new Pair(dist, point));
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int [][] res = new int[k][2];
        int i = 0;

        while(!pq.isEmpty()) {
            res[i++] = pq.poll().point;
        }

        return res;
    }
}
