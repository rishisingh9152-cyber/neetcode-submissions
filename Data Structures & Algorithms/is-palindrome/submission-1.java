class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        String b = s.replaceAll("\\s+", "");
        int i = 0;
        int j = b.length() - 1;
        
        while (i < j) {
            char left = b.charAt(i);
            char right = b.charAt(j);
            
            if (!Character.isLetterOrDigit(left)) {
                i++;
            } 
            // Fixed: check 'right' instead of 'left' here!
            else if (!Character.isLetterOrDigit(right)) {
                j--;
            } 
            else {
                if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                    return false; // Mismatch found!
                }
                i++;
                j--;
            }
        }
        
        return true; 
    }
}