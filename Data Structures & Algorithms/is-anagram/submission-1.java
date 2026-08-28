class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            // Here I know that both strings are equal lenght, I can run a single loop
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (!Character.isLowerCase(a) || !Character.isLowerCase(b)) {
                // contraint broke, chars must be in lower case
                return false;
            }
        }

        java.util.Map<Character, Integer> firstStringChars = new java.util.HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firstStringChars.containsKey(c)) {
                Integer count = firstStringChars.get(c);
                firstStringChars.put(c, count + 1);
            } else {
                firstStringChars.put(c, 1);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            if (!firstStringChars.containsKey(c)) {
                return false;
            }
            Integer count = firstStringChars.get(c);
            if (count == 1) {
                firstStringChars.remove(c);
            } else {
                firstStringChars.put(c, count - 1);
            }
        }

        return firstStringChars.isEmpty();
    }
}
