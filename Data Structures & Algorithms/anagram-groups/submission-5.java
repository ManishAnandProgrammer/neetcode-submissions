class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String s: strs) {
            String key = charFrequency(s);
            if (result.containsKey(key)) {
                result.get(key).add(s);
            } else {
                List<String> group = new ArrayList<>();
                group.add(s);

                result.put(key, group);
            }
        }

        return result.values().stream().toList();
    }

    private String charFrequency(String s1) {
        int[] temp = new int[123];
        for (int i = 0; i < s1.length(); i++) {
            int indexOfS1Char = (int) s1.charAt(i);
            int existingValueBeforeAdd = temp[indexOfS1Char];
            temp[indexOfS1Char] = existingValueBeforeAdd + 1;
        }
        return Arrays.toString(temp);
    }

}
