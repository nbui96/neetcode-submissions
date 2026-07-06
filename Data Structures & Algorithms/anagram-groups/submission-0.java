class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> answer = new HashMap<>();

        for (String str: strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String strSorted = new String(strArray);
            answer.putIfAbsent(strSorted, new ArrayList<>());
            answer.get(strSorted).add(str);
        }

        return new ArrayList<>(answer.values());
    }
}
