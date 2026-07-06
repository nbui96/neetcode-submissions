class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int result = 0;

        while (right < prices.length) {
            result = Math.max(result, prices[right] - prices[left]);
            if (prices[left] >= prices[right]) {
                left = right;
            }
            right = right + 1;
        }

        return result;
    }
}
