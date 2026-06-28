class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>(); 

        dfs(nums,subset,0, res);
    return res;
    }   

    private void dfs(int [] nums,  List<Integer> subset, int i, List<List<Integer>> res) {
        if(i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(nums, subset, i + 1, res);
        subset.remove(subset.size() - 1);
        dfs(nums, subset, i + 1, res);
    }
}
