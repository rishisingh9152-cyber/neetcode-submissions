class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       
        Set<List<Integer>> uniqueTriplets = new HashSet<>();
        
        
        Arrays.sort(nums);
        
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum == target) {
                    
         
                    uniqueTriplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Move pointers inward normally
                    left++;
                    right--;
                } 
                else if (sum < target) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }
        
        // Convert the Set back to a standard List before returning
        return new ArrayList<>(uniqueTriplets);
    }
}