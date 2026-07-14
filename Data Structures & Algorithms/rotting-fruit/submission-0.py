class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = deque([])
        turn = 0
        fresh = 0

        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == 1: fresh += 1
                if grid[r][c] == 2: q.append((r, c))

        directions = [
            [0, 1],
            [0, -1],
            [-1, 0],
            [1, 0]
        ]

        while fresh > 0 and q:
            bfs = len(q)
            for i in range(bfs):
                r, c = q.popleft()

                for dr, dc in directions:
                    new_r, new_c = r + dr, c + dc
                    if (new_r in range(len(grid))
                        and new_c in range(len(grid[0]))
                        and grid[new_r][new_c] == 1
                    ):
                        grid[new_r][new_c] = 2
                        q.append((new_r, new_c))
                        fresh -= 1
            turn += 1
        return turn if fresh == 0 else -1