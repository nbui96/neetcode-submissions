class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        row, col = m, n

        dp = [[1 for _ in range(col)] for _ in range(row)]

        for i in range(1, row):
            for j in range(1, col):
                dp[i][j] = dp[i - 1][j] + dp [i][j - 1]

        return dp[m - 1][n - 1]