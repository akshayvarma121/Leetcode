class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0, new StringBuilder(), result, 0, 0, n);
        return result;
    }

    private void backtrack(
        int idx,
        StringBuilder s,
        List<String> result,
        int openUsed,
        int closeUsed,
        int n
    ) {
        // Base case: built a string of length 2*n
        if (idx == 2 * n) {
            result.add(s.toString());
            return;
        }

        // ---------- PICK '(' ----------
        // Can pick '(' only if we haven't used all n opens
        if (openUsed < n) {
            s.append('(');
            backtrack(idx + 1, s, result, openUsed + 1, closeUsed, n);
            s.deleteCharAt(s.length() - 1); // backtracking: undo
        }

        // ---------- PICK ')' ----------
        // Can pick ')' only if we have more opens than closes so far
        if (closeUsed < openUsed) {
            s.append(')');
            backtrack(idx + 1, s, result, openUsed, closeUsed + 1, n);
            s.deleteCharAt(s.length() - 1); // backtracking: undo
        }

        // ---------- SKIP ----------
        // For well-formed parentheses, every position must be either '(' or ')'.
        // A true skip that leaves the position empty would produce invalid strings,
        // so we do NOT add a skip branch that adds nothing at this index.
    }
}