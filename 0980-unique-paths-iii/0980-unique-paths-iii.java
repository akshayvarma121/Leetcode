class Solution {
    // Directions: up, down, left, right
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int rows, cols;
    private int totalNonObstacles;  // number of cells we must visit
    private int result;             // number of valid paths

    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int startX = 0, startY = 0;
        totalNonObstacles = 0;

        // Find start and count non-obstacle cells (including start and end)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != -1) {
                    totalNonObstacles++;
                }
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        result = 0;
        // Start DFS from the starting square, visitedCount = 1 (start cell)
        dfs(grid, startX, startY, 1);
        return result;
    }

    private void dfs(int[][] grid, int x, int y, int visitedCount) {
        // If we reached the ending square
        if (grid[x][y] == 2) {
            // Count this path only if we have visited all non-obstacle cells
            if (visitedCount == totalNonObstacles) {
                result++;
            }
            return;
        }

        int temp = grid[x][y];
        grid[x][y] = -1; // mark as visited

        for (int[] d : DIRS) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] != -1) {
                dfs(grid, nx, ny, visitedCount + 1);
            }
        }

        grid[x][y] = temp; // backtrack (unmark)
    }
}