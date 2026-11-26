
class Solution {
    public int climbStairs(int n) {
        Map<Integer, Long> memo = new HashMap<>();
        return (int) helper(n, memo); 
    }
    
    private static long helper(int n, Map<Integer, Long> memo) {
       
        if (n <= 2) {
            return n;
        }
        
       
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
       
        long result = helper(n - 1, memo) + helper(n - 2, memo);
        memo.put(n, result);
        
        return result;
    }        
}