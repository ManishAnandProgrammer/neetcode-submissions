class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // nlogn

        Set<String> alreadyAdded = new HashSet<>();

        int targetSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int newTargetSum = targetSum - nums[i];

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int twoSum = nums[j] + nums[k];
                boolean targetMatched = newTargetSum == twoSum;

                if (targetMatched) {
                    String uniqueCheckString = valuesAsString(nums[i], nums[j], nums[k]);
                    if (alreadyAdded.contains(uniqueCheckString)) {
                        j++;
                        k--;
                        continue;
                    }

                    result.add(List.of(nums[i], nums[j], nums[k]));
                    alreadyAdded.add(uniqueCheckString);
                    j++;
                    k--;
                } else {
                    boolean decreaseK = twoSum > newTargetSum;
                    if (decreaseK) {
                        k--;
                    } else {
                        // Or increase j
                        j++;
                    }
                }

            }
        }
        
        return result;
    }

    private String valuesAsString(int i, int j, int k) {
        return String.format("%d__%d__%d", i, j, k);
    }
}
