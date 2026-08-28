class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        String str = sb.toString();

        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            char front = str.charAt(i);
            char back = str.charAt(j);

            if (front != back) {
                return false;
            }
        }

        return true;
    }
}
