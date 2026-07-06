class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [-1] * (amount + 1)
        dp[0] = 0

        for i in range(1, amount + 1):
            for coin in coins:
                if i < coin: continue
                if dp[i - coin] == -1: continue
                coin_needed = dp[i - coin] + 1
                if dp[i] == -1:
                    dp[i] = coin_needed
                else:
                    dp[i] = min(dp[i], coin_needed)
        
        return dp[amount]