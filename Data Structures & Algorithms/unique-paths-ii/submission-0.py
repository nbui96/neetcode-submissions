class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        row, col = len(obstacleGrid), len(obstacleGrid[0])

        trace = [[0 for _ in range(col)] for _ in range(row)]

        for i in range(col):
            if obstacleGrid[0][i] == 1:
                break
            trace[0][i] = 1

        for i in range(row):
            if obstacleGrid[i][0] == 1:
                break
            trace[i][0] = 1

        for i in range(1, row):
            for j in range(1, col):
                if obstacleGrid[i][j] == 1:
                    trace[i][j] = 0
                else:
                    trace[i][j] = trace[i - 1][j] + trace[i][j - 1]

        return trace[row - 1][col - 1]