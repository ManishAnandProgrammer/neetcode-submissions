class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        boolean invalidNumsLength = nums.length < 1 || nums.length > 10_000;
        if (invalidNumsLength) {
            return null;
        }

        for (int num: nums) {
            boolean invalidNumValue = num < -1000 || num > 1000;
            if (invalidNumValue) {
                return null;
            }
        }

        Set<Integer> uniqueValues = new HashSet<>();
        for (int num: nums) {
            uniqueValues.add(num);
        }
        boolean invalidTopK = k < 1 || k > uniqueValues.size();
        if (invalidTopK) {
            return null;
        }

        Map<Integer, Integer> valueCounter = new HashMap<>();
        for (int num: nums) {
            if (valueCounter.containsKey(num)) {
                Integer count = valueCounter.get(num);
                valueCounter.put(num, count + 1);
            } else {
                valueCounter.put(num, 1);
            }
        }

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            Integer topKey = null;
            Integer topKeyCount = null;

            for (Integer val: valueCounter.keySet()) {
                Integer currentValCount = valueCounter.get(val);
                if (topKeyCount == null) {
                    topKey = val;
                    topKeyCount = currentValCount;
                } else {
                    boolean newValHasMoreCount = currentValCount > topKeyCount;
                    if (newValHasMoreCount) {
                        topKey = val;
                        topKeyCount = currentValCount;
                    }
                }
            }

            topK[i] = topKey;
            valueCounter.remove(topKey);
        }

        return topK;
    }
}
