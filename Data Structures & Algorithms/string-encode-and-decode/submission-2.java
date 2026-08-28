class Solution {

    public String encode(List<String> strs) {
        boolean invalidStrsLength = Objects.isNull(strs) || strs.size() > 100;
        if (invalidStrsLength) {
            return null;
        }
        for (String s: strs) {
            boolean isNull = Objects.isNull(s);
            if (isNull) {
                return null;
            }
            boolean invalidLength = s.length() > 200;
            if (invalidLength) {
                return null;
            }

            for (char c: s.toCharArray()) {
                if (c > 127) {
                    // Not ASCII
                    return null;
                }
            }
        }

        char delimiter = (char) 162;
        StringBuilder builder = new StringBuilder();
        for (String s: strs) {
            int stringLength = s.length();
            builder.append(stringLength);
            builder.append(delimiter);
            builder.append(s);
        }

        return builder.toString();
    }

    public List<String> decode(String str) {
        char delimiter = (char) 162;
        if (str.isEmpty()) {
            return List.of();
        }

        // Here I know that I am going to encouter a number first
        // followed by delimiter
        List<String> result = new ArrayList<>();

        // Staring with zero, I am sure here that first index will be the number
        // that contains length of the string
        int currentNumberIndex = 0; 

        while (currentNumberIndex < str.length()) {
            // Initially keeping it same
            int currentDelimiterIndex = currentNumberIndex;

            // Find out actual index of delimiter
            boolean foundDelimiter = false;
            while (!foundDelimiter) {
                // Here loop is because it is possible that there is a string of length 10 or 100
                // in that case I have to read first 2 or 3 chars to find out count
                currentDelimiterIndex++;
                char possibleDelimiter = str.charAt(currentDelimiterIndex);
                if (possibleDelimiter == delimiter) {
                    foundDelimiter = true;
                }
            }

            String nextRead = str.substring(currentNumberIndex, currentDelimiterIndex);
            int charToRead = Integer.parseInt(nextRead);

            // Now I know how many characters I need to read after the delimiter
            int startIndexOfString = currentDelimiterIndex + 1;
            int endIndexOfString = startIndexOfString + charToRead;

            String stringToAdd = str.substring(startIndexOfString, endIndexOfString);
            result.add(stringToAdd);

            // Now I need to update the current number index to the next number
            currentNumberIndex = endIndexOfString;
        }

        return result;
    }
}
