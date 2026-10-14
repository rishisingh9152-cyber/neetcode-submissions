
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Iterate through the array, fixing one number at a time
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate anchor numbers to avoid duplicate triplets in the result
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Step 3: Use two pointers for the remaining array
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i]; // We need left + right to equal -nums[i]
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum == target) {
                    // Found a valid triplet! Add it directly.
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for the left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for the right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move pointers inward to look for new pairs
                    left++;
                    right--;
                } 
                else if (sum < target) {
                    left++; // Sum is too small, move left up to increase sum
                } 
                else {
                    right--; // Sum is too big, move right down to decrease sum
                }
            }
        }
        
        return result;
    }
}