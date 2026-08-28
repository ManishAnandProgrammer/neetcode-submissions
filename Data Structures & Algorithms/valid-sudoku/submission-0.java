class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> validChars = Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9', '.');

        if (board.length != 9) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i].length != 9) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (!validChars.contains(c)) {
                    return false;
                }
            }
        }

        // Here i is for row
        for (int i = 0; i < board.length; i++) {
            Set<Character> foundChars = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                char rowChar = board[i][j];
                if (rowChar != '.' && foundChars.contains(rowChar)) {
                    return false;
                }
                foundChars.add(rowChar);
            }
        }

        // Here i is for column
        for (int i = 0; i < board.length; i++) {
            Set<Character> foundChars = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                char columnChar = board[j][i];
                if (columnChar != '.' && foundChars.contains(columnChar)) {
                    return false;
                }
                foundChars.add(columnChar);
            }
        }

        // box solve
        Map<Integer, Set<Character>> boxMap = new HashMap<>();
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                int boxNumber = (3 * (row / 3)) + (column/3);
                char charValue = board[row][column];

                if (boxMap.containsKey(boxNumber)) {
                    Set<Character> boxValues = boxMap.get(boxNumber);
                    if (charValue != '.') {
                        if (boxValues.contains(charValue)) {
                            return false;
                        } else {
                            boxValues.add(charValue);
                        }
                    }
                } else {
                    Set<Character> boxValues = new HashSet<>();
                    boxValues.add(charValue);

                    boxMap.put(boxNumber, boxValues);
                }
            }
        }

        return true;
    }
}
