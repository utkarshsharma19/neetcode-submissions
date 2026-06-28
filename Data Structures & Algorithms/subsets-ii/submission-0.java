class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums); 
        List<List<Integer>> result = new ArrayList<>();
        recursion(nums, 0, current, result);

        return result;
    }

    private void recursion(int [] nums, int index, List<Integer> current, List<List<Integer>> result) {
         result.add(new ArrayList<>(current));
        
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
        current.add(nums[i]);
        recursion(nums,i + 1,current,result);
        current.remove(current.size() - 1);
    }
    }
}
