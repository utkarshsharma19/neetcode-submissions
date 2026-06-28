class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int i = 0; i <= nums.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int [] result = new int[k];
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            bucket[count].add(num);
        }

        for(int i = nums.length; i >= 0 && index < k; i--) {
            for (int num : bucket[i]) {
                result[index++] = num;
                if (index == k) {
                    break;
                }
            }
        }

        return result;
     }
}
