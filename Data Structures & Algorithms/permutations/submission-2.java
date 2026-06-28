class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        permuteHelper(nums, new ArrayList<>(), new boolean[nums.length]);

        return res;
    }
    private void permuteHelper(int[] nums, List<Integer> perm, boolean [] pick) {
        if(perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!pick[i]) {
            perm.add(nums[i]);
            pick[i] = true;
            permuteHelper(nums, perm, pick);
            perm.remove(perm.size() - 1);
            pick[i] = false;
            }
            
        }
    }
}
