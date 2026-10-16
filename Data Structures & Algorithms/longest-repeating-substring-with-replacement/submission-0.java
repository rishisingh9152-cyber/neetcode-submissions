class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // Tracks frequency of characters 'A' through 'Z'
        int left = 0;
        int maxLength = 0;
        int maxCount = 0; // Tracks the frequency of the most frequent character in the current window
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            count[currentChar - 'A']++;
            
            // Update maxCount if our new character has the highest frequency so far
            maxCount = Math.max(maxCount, count[currentChar - 'A']);
            
            // Current window size = right - left + 1
            // If window size minus the most frequent character > k, we have too many errors!
            // Shrink from the left.
            if ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            
            // Update our max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}