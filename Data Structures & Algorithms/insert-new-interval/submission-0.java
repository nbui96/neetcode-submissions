class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] combinedIntervals = new int[intervals.length + 1][];
        combinedIntervals[0] = newInterval;

        for (int i = 1; i < combinedIntervals.length; i++) {
            combinedIntervals[i] = intervals[i - 1];
        }

        Arrays.sort(combinedIntervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        for (int[] interval: combinedIntervals) {
            if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(
                    merged.get(merged.size() - 1)[1],
                    interval[1]
                );
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
