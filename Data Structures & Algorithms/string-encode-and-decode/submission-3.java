class Solution {

    public String encode(List<String> strs) {
        String delimiter = "#";
        StringBuilder builder = new StringBuilder();
        for (String s: strs) {
            builder.append(s.length());
            builder.append(delimiter);
            builder.append(s);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < str.length();) {
            StringBuilder stringLength = new StringBuilder();
            for (int j = i; j < str.length(); j++) {
                char c = str.charAt(j);
                if (Character.isDigit(c)) {
                    stringLength.append(c);
                } else if (c == '#') {
                    break;
                } else {
                    break;
                }
            }

            // for example i have 2#TO3#CAT
            // stringLength.length() will be 1 and adding 1 for '#'
            // next iteration should start from i = 2 + originalStringLength -> 2;
            int originalStringLength = Integer.parseInt(stringLength.toString());
            int stringStartFrom = i + stringLength.length() + 1;
            int staringEndAt = stringStartFrom + originalStringLength;
            i =  stringStartFrom + originalStringLength;

            String extracedString = str.substring(stringStartFrom, staringEndAt);
            results.add(extracedString);
        }

        return results;
    }

    private static class StringStartEnd {
        private final int startIndex;
        private final int endIndex;

        StringStartEnd(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public int getStartIndex() {
            return this.startIndex;
        }

        public int getEndIndex() {
            return this.endIndex;
        }
    }
}
