class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, new StringBuilder(), n, 0, 0);
        return result;
    }

    private void backtracking(
        List<String> result,
        StringBuilder sb,
        int n,
        int openCount,
        int closeCount
    ) {
        if (openCount == n && closeCount == n) {
            result.add(sb.toString());
            return;
        }

        if (openCount < n) {
            sb.append("(");
            backtracking(result, sb, n, openCount + 1, closeCount);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeCount < openCount) {
            sb.append(")");
            backtracking(result, sb, n, openCount, closeCount + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
