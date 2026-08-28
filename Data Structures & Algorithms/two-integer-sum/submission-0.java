class Solution {
    public int[] twoSum(int[] nums, int target) {
        boolean validArrayLength = nums.length >= 2 && nums.length <= 1000;
        if (!validArrayLength) {
            return null;
        }

        int maxNumberAllowed = 10_000_000;
        int minNumberAllowed = -10_000_000;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > maxNumberAllowed || num < minNumberAllowed) {
                return null;
            }
        }

        int maxTargetAllowed = 10_000_000;
        int minTargetAllowed = -10_000_000;

        if (target > maxTargetAllowed || target < minTargetAllowed) {
            return null;
        }

        Map<Integer, Integer> numberWithIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numberWithIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            int requiredNumberToSatisfyTarget = target - num;

            if (numberWithIndex.containsKey(requiredNumberToSatisfyTarget)) {
                int indexOfMatchingNumber = numberWithIndex.get(requiredNumberToSatisfyTarget);   
                if (indexOfMatchingNumber != i) {
                    return new int[] {i, indexOfMatchingNumber};
                }
            }
        }

        return null;
    }
}
