class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        backtrack(0,list, nums);

        return result;
    }

    private void backtrack(int start, List<Integer> list, int[] nums) {
        result.add(new ArrayList<>(list));

        for(int index = start; index < nums.length; index++) {
            list.add(nums[index]);
            backtrack(index + 1, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
