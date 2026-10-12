
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        // Map to store the sorted string as key and the group of anagrams as value
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Convert the string to a character array and sort it
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);
            
            // If the key is not in the map yet, initialize a new list
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }
            
            // Add the original string to its corresponding anagram group
            map.get(sortedKey).add(s);
        }
        
        // Return all the grouped lists from the map values
        return new ArrayList<>(map.values());
    }
}