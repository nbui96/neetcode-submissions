class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationRecursive(nums, result, new ArrayList<>(), 0, target);
        return result;
    }

    private void combinationRecursive(
        int[] nums,
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

        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            combinationRecursive(nums, result, subset, i, target - nums[i]);
            subset.remove(subset.size() - 1);
        }
    }
}
