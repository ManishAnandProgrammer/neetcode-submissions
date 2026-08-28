class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            boolean targetMatched = sum == target;
            if (targetMatched) {
                return new int[] {i + 1, j + 1};
            } else {
                boolean decreaseJ = sum > target;
                if (decreaseJ) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        return null;
    }
}
