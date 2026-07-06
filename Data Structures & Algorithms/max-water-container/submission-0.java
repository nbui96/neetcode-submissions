class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;
        int max = 0;

        while (start != end) {
            int area = Math.abs(Math.min(heights[start], heights[end]) * (start - end));
            max = Math.max(max, area);

            if (heights[start] < heights[end]) {
                start += 1;
            } else {
                end -= 1;
            }

        }

        return max;
    }
}
