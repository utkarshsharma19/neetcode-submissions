class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs(0, 0, n, res, sb);
        return res;
    }

    private void dfs(int open, int close, int n, List<String> res, StringBuilder sb) {
        if (open == n && close == n) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            dfs(open + 1, close, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            dfs(open, close + 1, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}