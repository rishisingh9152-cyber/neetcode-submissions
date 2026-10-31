class Solution {
   
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int i, int target, List<Integer> currList, List<List<Integer>> result) {
        // Base case: if target is met, add a copy of the current list to results
        if (target == 0) {
            result.add(new ArrayList<>(currList));
            return;
        }
        
        // Base case: if we go out of bounds or target drops below zero, stop
        if (i == nums.length || target < 0) {
            return;
        }

        // Choice 1: Include the current element. 
        // Stay at index 'i' because we are allowed to reuse the same number.
        currList.add(nums[i]);
        backtrack(nums, i, target - nums[i], currList, result);
        
        // Backtrack (un-choose the element)
        currList.remove(currList.size() - 1);

        // Choice 2: Skip the current element and move to the next index 'i + 1'
        backtrack(nums, i + 1, target, currList, result);
    }
}

