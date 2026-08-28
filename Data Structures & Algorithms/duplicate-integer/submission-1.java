class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length <= 0 && nums.length >= (int) Math.pow(10, 5)) {
            throw new RuntimeException("Invalid Input");
        }

        int minimumNumberCanBe = (int) Math.pow(-10, 9);
        int maximumNumberCanBe = (int) Math.pow(10, 9);

        Set<Integer> alreadyFoundNumbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            if (currentNumber < minimumNumberCanBe || currentNumber > maximumNumberCanBe) {
                throw new RuntimeException("Invalid Number: " + currentNumber);
            }
            if (alreadyFoundNumbers.contains(currentNumber)) {
                return true;
            } else {
                alreadyFoundNumbers.add(currentNumber);
            }
        }

        return false;
    }
}