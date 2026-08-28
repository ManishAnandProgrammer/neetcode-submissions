class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean invalidStrsLength = strs.length < 1 || strs.length > 1000;
        if (invalidStrsLength) {
            return null;
        }
        for (String s: strs) {
            if (Objects.isNull(s) || s.length() > 100) {
                return null;
            }
            for (char c: s.toCharArray()) {
                if (!Character.isLowerCase(c)) {
                    return null;
                }
            }
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] carray = s.toCharArray();
            Arrays.sort(carray);
            
            String sortedString = new String(carray);
            if (map.containsKey(sortedString)) {
                List<String> values = map.get(sortedString);
                values.add(s);
            } else {
                List<String> values = new ArrayList<>();
                values.add(s);

                map.put(sortedString, values);
            }
        }

        Set<String> keys = map.keySet();
        List<List<String>> result = new ArrayList<>(keys.size());

        for (String key: keys) {
            result.add(map.get(key));
        }

        return result;
    }
}
