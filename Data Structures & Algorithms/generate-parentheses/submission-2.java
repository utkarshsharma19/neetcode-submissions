class Solution {
    
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs(0,0,n, res, sb);
        return res;
    }

    private void dfs(int openN, int closeN, int n, List<String> res, StringBuilder stack) {
        if (openN == n && closeN == n) {
            res.add(stack.toString());
            return;
        }
        if(openN < n) {
            stack.append('(');
            dfs(openN + 1, closeN, n, res, stack);
            stack.deleteCharAt(stack.length() -1);
        }

        if(closeN < openN) {
            stack.append(')');
            dfs(openN, closeN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() -1);
        }
    }
}
