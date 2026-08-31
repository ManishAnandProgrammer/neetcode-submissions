class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixMultiplication = new int[nums.length + 1];
        prefixMultiplication[0] = 1; // 1 is identity in multiplication

        for (int i = 1; i <= nums.length; i++) {
            int previousResult = prefixMultiplication[i - 1];
            int currentValue = nums[i - 1];

            prefixMultiplication[i] = previousResult * currentValue;
        }

        int[] postfixMultiplication = new int[nums.length + 1];
        postfixMultiplication[postfixMultiplication.length - 1] = 1; // again identity value

        for (int i = nums.length; i > 0; i--) {
            int previousResult = postfixMultiplication[i];
            int currentValue = nums[i - 1];

            postfixMultiplication[i - 1] = previousResult * currentValue;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int first = prefixMultiplication[i];
            int second = postfixMultiplication[i+1];

            result[i] = first * second;
        }

        return result;
    }
}  
