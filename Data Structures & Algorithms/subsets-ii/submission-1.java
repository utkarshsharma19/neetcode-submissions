class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        bacltrack(0,nums, new ArrayList<>());
        return res;
    }

    private void bacltrack(int i, int [] nums, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for(int start = i; start < nums.length; start++) {
            if (start > i && nums[start] == nums[start - 1]) {
                continue;
            }

            list.add(nums[start]);
            bacltrack(start + 1, nums, list);
            list.remove(list.size() - 1);
        }
    }

}
