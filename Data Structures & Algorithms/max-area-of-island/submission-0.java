class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }

        return max;
    }

    private int dfs(
        int[][] grid,
        int row,
        int col
    ) {

        if (row < 0 || col < 0 || row >= grid.length ||
            col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;
        int area = 1;

        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            area += dfs(grid, row + 1, col);
        }

        if (row - 1 > -1  && grid[row - 1][col] == 1) {
            area += dfs(grid, row - 1, col);
        }

        if (col + 1 < grid[row].length  && grid[row][col + 1] == 1) {
            area += dfs(grid, row, col + 1);
        }

        if (col - 1 > -1  && grid[row][col - 1] == 1) {
            area += dfs(grid, row, col - 1);
        }

        return area;
    }
}
