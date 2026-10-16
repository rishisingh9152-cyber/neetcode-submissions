
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        // 1. Build the target frequency map for string t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        
        int required = targetMap.size(); // Total unique characters to match
        int formed = 0;                  // Unique characters currently meeting quota
        
        Map<Character, Integer> windowMap = new HashMap<>();
        
        // Pointers and tracking variables for the minimum window
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0; // Tracks the start index of our best substring
        
        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            
            // If the current character's frequency matches its target frequency, increment formed
            if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }
            
            // 2. Contract the window from the left while it is valid
            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);
                
                // Check if this new valid window is smaller than our previous record
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                // Remove the left character from the window map
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                
                // If removing this character breaks our validity, decrement formed
                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    formed--;
                }
                
                left++; // Shrink window from the left
            }
            
            right++; // Expand window to the right
        }
        
        // If minLen was never updated, no valid window was found
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}