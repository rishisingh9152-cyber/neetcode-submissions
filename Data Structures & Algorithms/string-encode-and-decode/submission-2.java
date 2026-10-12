class Solution {

   public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            int j = i;
            // Find the position of the delimiter '#'
            while (s.charAt(j) != '#') {
                j++;
            }
            
            // Parse the length of the string
            int length = Integer.parseInt(s.substring(i, j));
            
            // Extract the string based on its length
            String str = s.substring(j + 1, j + 1 + length);
            result.add(str);
            
            // Move pointer 'i' to the start of the next encoded block
            i = j + 1 + length;
        }
        
        return result;
    }
}
