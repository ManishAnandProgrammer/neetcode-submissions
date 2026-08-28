class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCounter = new int[123];
        for (int i = 0; i < s.length(); i++) {
            int currentCharIndex = (int) s.charAt(i);
            int valueOnCurrentCharIndex = charCounter[currentCharIndex];
            charCounter[currentCharIndex] = valueOnCurrentCharIndex + 1;
        }

        for (int i = 0; i < t.length(); i++) {
            int currentCharIndex = (int) t.charAt(i);
            int valueOnCurrentCharIndex = charCounter[currentCharIndex];
            charCounter[currentCharIndex] = valueOnCurrentCharIndex - 1;
        }

        // lower cased alphabets starts with 97, ends with 122
        for (int i = 97; i <= 122; i++) {
            int valueAtIndex = charCounter[i];
            if (valueAtIndex != 0) {
                return false;
            }
        }

        return true;
    }
}
