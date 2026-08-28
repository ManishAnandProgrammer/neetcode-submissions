class Solution {
    public int[] productExceptSelf(int[] nums) {
        boolean invalidLength = nums.length < 2 || nums.length > 1000;
        if (invalidLength) {
            return null;
        }
        // for (int i: nums) {
        //     boolean invalidNumber = i < -20 || i > 20;
        //     if (invalidNumber) {
        //         return null;
        //     }
        // }

        int[] resultArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            
            int multiplicationResult = 1; // 1 doesn't change multiplication value
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                multiplicationResult = multiplicationResult * nums[j];
            }

            resultArray[i] = multiplicationResult;
        }

        return resultArray;
    }
}  
