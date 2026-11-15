class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // 1. Count odd-length palindromes (centered at index i)
            count += expandAndCount(s, i, i);
            
            // 2. Count even-length palindromes (centered between i and i + 1)
            count += expandAndCount(s, i, i + 1);
        }
        
        return count;
    }
    
    private int expandAndCount(String s, int left, int right) {
        int palindromes = 0;
        
        // Expand outward as long as bounds are valid and characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            palindromes++; // Found a valid palindromic substring
            left--;
            right++;
        }
        
        return palindromes;
    }
}