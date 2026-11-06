class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        // 1. Initialize the DP table
        int[] dp = new int[nums.length];
        
        // 2. Set base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        // 3. Fill the table using the recurrence relation
        for (int i = 2; i < nums.length; i++) {
            // Choice: (Rob current house + money from 2 houses ago) VS (Skip current house)
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        
        // 4. Return the final state
        return dp[nums.length - 1];
    }
    }

