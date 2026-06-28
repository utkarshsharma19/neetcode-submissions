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
List<Integer>[] buckets = new List[nums.length + 1];

for (Map.Entry<Integer,Integer> e : map.entrySet()) {
            int f = e.getValue();
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(e.getKey());
        }

        int[] res = new int[Math.min(k, map.size())];
        int idx = 0;

        for (int f = buckets.length - 1; f >= 0 && idx < k; f--) {
            if (buckets[f] == null) continue;
            for (int val : buckets[f]) {
                if (idx == k) break;
                res[idx++] = val;
            }
        }

        return res;
        }
        
    }
    
