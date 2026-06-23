class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        // initialize board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(board, 0, ans);
        return ans;
    }

    // backtracking on row
    private void solve(char[][] board, int row, List<List<String>> ans) {
        int n = board.length;

        // base case: all rows filled → one solution
        if (row == n) {
            ans.add(buildBoard(board));
            return;
        }

        // try placing queen in each column of current row
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, row + 1, ans);
                board[row][col] = '.';      // backtrack
            }
        }
    }

    // check column and two diagonals above (same logic you’d use in VS Code)
    private boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // upper‑left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // upper‑right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    // convert char[][] to List<String> as LeetCode expects
    private List<String> buildBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}