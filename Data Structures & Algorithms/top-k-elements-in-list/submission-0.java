class Node {
        int val;
        int count;
        Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

            List<Node> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            list.add(new Node(e.getKey(), e.getValue()));
        }

            

            Collections.sort(list, (a, b) -> Integer.compare(b.count, a.count));

            int size = Math.min(k, list.size());
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = list.get(i).val;
        }
        return ans;
    }
}
    
