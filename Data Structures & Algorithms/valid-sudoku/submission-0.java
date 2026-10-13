
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Our "clipboard" to track what numbers we have already seen
        Set<String> seen = new HashSet<>();
        
        // Loop through every single cell in the 9x9 board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char currentVal = board[r][c];
                
                // If the cell is empty ('.'), we don't care about it, skip!
                if (currentVal == '.') {
                    continue;
                }
                
                // Create three unique notes for our clipboard:
                String rowNote = currentVal + " is in row " + r;
                String colNote = currentVal + " is in col " + c;
                
                // Calculate which 3x3 box this cell is in (0 through 8)
                int boxIndex = (r / 3) * 3 + (c / 3);
                String boxNote = currentVal + " is in box " + boxIndex;
                
                // Try to add these notes to our clipboard. 
                // If .add() returns false, it means the note is ALREADY on the clipboard!
                // That means we found a duplicate, so the Sudoku is invalid.
                if (!seen.add(rowNote) || !seen.add(colNote) || !seen.add(boxNote)) {
                    return false;
                }
            }
        }
        
       // If we checked every cell and found no duplicates, the board is valid!
       return true; 
    }
}