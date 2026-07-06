class Solution {
    public int trap(int[] heights) {
        int globalMaxIndex = 0;
        int leftMaxIndex = 0;
        int rightMaxIndex = heights.length - 1;
        int result = 0;

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > heights[globalMaxIndex]) globalMaxIndex = i;
        }

        // Interate l -> r using globalMaxIndex as rightMaxIndex
        for (int i = 1; i < globalMaxIndex; i++) {
            if (heights[i] > heights[leftMaxIndex]) leftMaxIndex = i;
            result += heights[leftMaxIndex] - heights[i];
        }

        // Interate r -> l using globalMaxIndex as leftMaxIndex
        for (int i = heights.length - 2; i > globalMaxIndex; i--) {
            if (heights[i] > heights[rightMaxIndex]) rightMaxIndex = i;
            result += heights[rightMaxIndex] - heights[i];
        }

        return result;
    }
}
