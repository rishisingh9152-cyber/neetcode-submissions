class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> h = new HashMap<>();
        
        for (char x : s.toCharArray()) {
            h.put(x, h.getOrDefault(x, 0) + 1);
        }
        
        for (char y : t.toCharArray()) {
            // If the character isn't there, OR we've already used all of them up
            if (!h.containsKey(y) || h.get(y) == 0) {
                return false;
            }
            h.put(y, h.get(y) - 1);
        }
        
        return true;
    }
}