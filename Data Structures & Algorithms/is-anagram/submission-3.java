class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCounter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (charCounter.containsKey(currentChar)) {
                int existingCount = charCounter.get(currentChar);
                charCounter.put(currentChar, existingCount + 1);
            } else {
                charCounter.put(currentChar, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);
            if (charCounter.containsKey(currentChar)) {
                int newCount = charCounter.get(currentChar) - 1;
                if (newCount < 0) {
                    return false;
                }
                charCounter.put(currentChar, newCount);
            } else {
                return false;
            }
        }

        return true;
    }
}
