class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }

        return result;
    }

    private void dfs(
        char[][] grid,
        int row,
        int col
    ) {
        grid[row][col] = 'a';

        if (row + 1 < grid.length && grid[row + 1][col] == '1') {
            dfs(grid, row + 1, col);
        }

        if (row - 1 > -1 && grid[row - 1][col] == '1') {
            dfs(grid, row - 1, col);
        }

        if (col + 1 < grid[row].length && grid[row][col + 1] == '1') {
            dfs(grid, row, col + 1);
        }

        if (col - 1 > -1 && grid[row][col - 1] == '1') {
            dfs(grid, row, col - 1);
        }
    }
}
