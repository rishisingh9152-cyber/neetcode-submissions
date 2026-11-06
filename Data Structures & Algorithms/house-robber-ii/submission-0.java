class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        int n = nums.length;
        // Case 1: Rob from house 0 to n-2 (exclude last house)
        // Case 2: Rob from house 1 to n-1 (exclude first house)
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }
    
    public int helper(int[] nums, int start, int end) {
        // If the range only has 1 house
        if (start == end) {
            return nums[start];
        }
        
        int length = end - start + 1;
        int[] dp = new int[length];
        
        // Base cases for the subsegment
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        
        // Build the dp table for the range [start + 2, end]
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        
        // Return the final result of this subsegment
        return dp[length - 1];
    }
}