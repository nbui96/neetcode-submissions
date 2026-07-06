class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int currentMax = 0;
        int result = 1;
        int startingPoint = -9999999;

        for (int i: nums) {
            minHeap.add(i);
        }

        while (!minHeap.isEmpty()) {
            if (startingPoint == -9999999) {
                startingPoint = minHeap.poll();
                currentMax = 1;
            } else {
                System.out.print("dif: " + (minHeap.peek() - startingPoint));
                if (minHeap.peek() - startingPoint == 1) {
                    currentMax += 1;
                    System.out.print("cur max: " + currentMax);
                    result = Math.max(currentMax, result);
                    System.out.print("result: " + result);
                    startingPoint = minHeap.poll();
                } else if (minHeap.peek() - startingPoint > 1) {
                    currentMax = 1;
                    startingPoint = minHeap.poll();
                } else if (minHeap.peek() - startingPoint == 0) {
                    minHeap.poll();
                }
            }
        }

        return result;
    }
}
