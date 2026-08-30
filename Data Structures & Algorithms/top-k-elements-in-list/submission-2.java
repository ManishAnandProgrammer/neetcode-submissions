class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberCount = new HashMap<>();
        int maxCountSeen = 1;
        for (int i = 0; i < nums.length; i++) {
            if (numberCount.containsKey(nums[i])) {
                int oldCount = numberCount.get(nums[i]);
                int newCount = oldCount + 1;
                numberCount.put(nums[i], newCount);

                if (newCount > maxCountSeen) {
                    maxCountSeen = newCount;
                }
            } else {
                numberCount.put(nums[i], 1);
            }
        }

        TopElementHolder[] outer = new TopElementHolder[(maxCountSeen + 1)];
        for (int key: numberCount.keySet()) {
            int count = numberCount.get(key);
            TopElementHolder inner = outer[count];
            if (inner == null) {
                TopElementHolder holder = new TopElementHolder();
                holder.addElement(key);
                outer[count] = holder;
            } else {
                inner.addElement(key);
            }
        }

        List<Integer> resultList = new ArrayList<>(k);
        for (int i = outer.length - 1; i >= 0; i--) {
            if (resultList.size() == k) {
                break;
            }

            TopElementHolder holder = outer[i];
            if (holder != null) {
List<Integer> elements = holder.getElements();
            for (Integer e: elements) {
                resultList.add(e);
                if (resultList.size() == k) {
                    break;
                }
            }
            }
            
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class TopElementHolder {
        private List<Integer> elements;

        TopElementHolder() {
            this.elements = new ArrayList<>();
        }

        public void addElement(int element) {
            this.elements.add(element);
        }

        public List<Integer> getElements() {
            return this.elements;
        }
    }
}
