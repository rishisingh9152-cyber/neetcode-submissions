
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Step 1: Put all numbers into a HashSet for O(1) lookups
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }
        
        int longestStreak = 0;
        
        // Step 2: Iterate through the set and find sequence starts
        for (int n : numSet) {
            // Check if this number is the start of a sequence
            if (!numSet.contains(n - 1)) {
                int currentNum = n;
                int currentStreak = 1;
                
                // Count consecutive numbers going forward
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                
                // Keep track of the maximum streak found
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }
}