class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        combinationHelper(candidates, result, new ArrayList<>(), 0, target);
        return result;   
    }

    private void combinationHelper(
        int[] candidates,
        List<List<Integer>> result,
        List<Integer> subset,
        int startIndex,
        int target
    ) {
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // Skip duplicates: if current element equals previous element
            // and we're not at the start index, skip it
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            subset.add(candidates[i]);
            combinationHelper(candidates, result, subset, i + 1, target - candidates[i]);
            subset.remove(subset.size() - 1);
        }
    }
}