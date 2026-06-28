class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, target, new ArrayList<>(), candidates);
        return res;
    }

    private void backtrack(int start, int target, List<Integer> cur, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = start; j < candidates.length; j++) {
            if (j > start && candidates[j] == candidates[j - 1]) {
                continue;
            }

            if (candidates[j] > target) {
                break;
            }

            cur.add(candidates[j]);
            backtrack(j + 1, target - candidates[j], cur, candidates);
            cur.remove(cur.size() - 1);
        }
    }
}