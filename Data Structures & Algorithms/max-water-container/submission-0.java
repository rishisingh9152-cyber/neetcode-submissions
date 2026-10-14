class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        
        while (left < right) {
            // 1. Calculate the width and the limiting height
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            
            // 2. Calculate the current area and update maxWater if it's larger
            int currentArea = width * currentHeight;
            maxWater = Math.max(maxWater, currentArea);
            
            // 3. Move the pointer of the shorter wall inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
}