class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        // Min-heap ordered by frequency
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> countMap.get(a) - countMap.get(b)
        );

        for (int n : countMap.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll(); // Remove the least frequent
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }
        return result;
    }
}