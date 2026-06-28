class Twitter {
        private static class Node {
        int time;       // smaller means newer if we decrement time
        int tweetId;
        int userId;
        int index;      // index in that user's tweet list
        Node(int time, int tweetId, int userId, int index) {
            this.time = time;
            this.tweetId = tweetId;
            this.userId = userId;
            this.index = index;
        }
    }

    int time = 0;
    private final Map<Integer, List<int[]>> tweetMap;   
    private final Map<Integer, Set<Integer>> followMap;
    public Twitter() {
        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new int[]{time--, tweetId});

    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));

for (int followeeId : followMap.get(userId)) {
            List<int[]> tweets = tweetMap.get(followeeId);
            if (tweets == null || tweets.isEmpty()) continue;

            int idx = tweets.size() - 1; 
            int[] t = tweets.get(idx);
            pq.offer(new Node(t[0], t[1], followeeId, idx - 1));
        }

        List<Integer> res = new ArrayList<>(10);
        while (!pq.isEmpty() && res.size() < 10) {
            Node cur = pq.poll();
            res.add(cur.tweetId);

           
            if (cur.index >= 0) {
                int[] next = tweetMap.get(cur.userId).get(cur.index);
                pq.offer(new Node(next[0], next[1], cur.userId, cur.index - 1));
            }
        }

    

        return res;

        
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
