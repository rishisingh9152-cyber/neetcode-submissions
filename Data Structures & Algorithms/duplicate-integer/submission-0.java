class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Boolean> h = new HashMap<>();
        for (int x : nums) {
            // Check if the key already exists
            if (h.containsKey(x)) {
                return true; // Duplicate found!
            }
            // Add the element to the map
            h.put(x, true);
        }
        return false; // No duplicates found
    }
}