class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void recursion(int [] nums, int target, int start, List<Integer> current, List<List<Integer>> result) {
         if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            recursion(nums, target - nums[i], i, current, result); // not i + 1, because we can reuse
            current.remove(current.size() - 1);
        }
    }

}
