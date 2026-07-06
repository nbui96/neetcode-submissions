class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> targetMapping = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (targetMapping.containsKey(nums[i])) { return new int[] {targetMapping.get(nums[i]),i }; }

            targetMapping.put(target - nums[i], i);
        }

        return nums;
    }
}
