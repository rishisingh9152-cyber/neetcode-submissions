class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Try starting the word search from every cell on the board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0) && backtrack(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int r, int c, int index) {
        // Base case: If we have matched all characters in the word
        if (index == word.length()) {
            return true;
        }
        
        // Boundary checks and character mismatch check
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        
        // 1. Choose: Mark the current cell as visited by temporarily changing its value
        char temp = board[r][c];
        board[r][c] = '#';
        
        // 2. Explore: Recursively check all 4 directions (Down, Up, Right, Left)
        boolean found = backtrack(board, word, r + 1, c, index + 1) ||
                        backtrack(board, word, r - 1, c, index + 1) ||
                        backtrack(board, word, r, c + 1, index + 1) ||
                        backtrack(board, word, r, c - 1, index + 1);
        
        // 3. Un-choose (Backtrack): Restore the original character
        board[r][c] = temp;
        
        return found;
    }

}