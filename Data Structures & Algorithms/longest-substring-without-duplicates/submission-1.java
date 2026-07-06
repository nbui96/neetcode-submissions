class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int result = 0;
        char[] sCharArray = s.toCharArray();
        HashMap<Character, Integer> charToIndex = new HashMap<>();

        while (right < s.length()) {
            if (charToIndex.containsKey(sCharArray[right])) {
                left = Math.max(left, charToIndex.get(sCharArray[right]) + 1);
            }

            charToIndex.put(sCharArray[right], right);
            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}
