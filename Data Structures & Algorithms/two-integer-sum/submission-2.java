class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ithIndexValue = nums[i];
            int desiredPairValue = target - ithIndexValue;
            if (valueIndexMap.containsKey(desiredPairValue)) {
                int indexOfPair = valueIndexMap.get(desiredPairValue);
                return new int[] {indexOfPair, i};
            } else {
                valueIndexMap.put(ithIndexValue, i);
            }
        }

        return new int[0];
    }
}
