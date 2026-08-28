class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>(nums.length);
        for (int i: nums) {
            numSet.add(i);
        }

        int longestSequence = 1;
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            boolean startOfTheSequence = !numSet.contains(currentValue - 1);
            if (startOfTheSequence) {
                int sequence = 1;
                int nextValueOfSequence = currentValue + 1;
                while (true) {
                    if (numSet.contains(nextValueOfSequence)) {
                        sequence++;
                        nextValueOfSequence++;
                    } else {
                        break;
                    }
                }

                if (sequence > longestSequence) {
                    longestSequence = sequence;
                }
            }

        }

        return longestSequence;
    }
}
