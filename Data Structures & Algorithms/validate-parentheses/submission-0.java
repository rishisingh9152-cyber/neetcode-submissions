
class Solution {
    public boolean isValid(String s) {
        // Use ArrayDeque to act as our stack
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            // 1. If it's an opening bracket, push its expected CLOSING counterpart
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // 2. If it's a closing bracket
            else {
                // If the stack is empty (no matching open bracket) 
                // OR the popped character doesn't match current char -> INVALID!
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        
        // 3. If the stack is completely empty, everything matched successfully!
        return stack.isEmpty();
    }
}