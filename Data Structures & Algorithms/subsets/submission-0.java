class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void subsetsHelper(
        int[] nums,
        List<List<Integer>> result,
        List<Integer> subset,
        int start
    ) {
        if (subset.size() == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        result.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            subsetsHelper(nums, result, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
