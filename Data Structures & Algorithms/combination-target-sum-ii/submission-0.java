class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashMap<Integer, List<Integer>> memo = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, current, result);

        return result;
    }

    private void dfs(int[] candidates, int target, int index,  List<Integer> current, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if(candidates[i]>target) {
                break;
            }

            current.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
