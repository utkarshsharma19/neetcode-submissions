class Solution {
     List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
       result = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);

        return result;
    }

    private void backtrack(List<Integer> perm, int [] nums, boolean[] pick) {
        if(perm.size() == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!pick[i]) {
                perm.add(nums[i]);
                pick[i] = true;
                backtrack(perm, nums, pick);
                perm.remove(perm.size() - 1);
                pick[i] = false;
            }
        }
    }


}
