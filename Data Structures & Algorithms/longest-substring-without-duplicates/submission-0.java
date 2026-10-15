
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        
        // Note: Using HashSet<Character> is standard:
        Set<Character> window = new HashSet<>();
        
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If the character is already in our window, shrink from the left
            while (window.contains(currentChar)) {
                window.remove(s.charAt(left));
                left++; // Move left pointer up
            }
            
            // Add the new character to our window
            window.add(currentChar);
            
            // Calculate current window size and update maxLength
            int currentLength = right - left + 1;
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
}