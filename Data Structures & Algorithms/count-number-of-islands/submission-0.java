class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Fixed: Use character literal '1' instead of string "1"
                if (grid[i][j] == '1') {
                    result++;
                    dfs(n, m, i, j, grid);
                }
            }
        }
        return result;
    }
    
    public boolean valid(int i, int j, int n, int m) {
        // Fixed: Check bounds using >= 0 and && instead of > 0 and ||
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    
    public void dfs(int n, int m, int i, int j, char[][] a) {
        // Mark the current cell as visited by changing it to '0'
        a[i][j] = '0';
        
        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};
        
        for (int k = 0; k < 4; k++) {
            int newRow = i + rowDir[k];
            int newCol = j + colDir[k];
            
            // Check if the neighbor is valid and is unvisited land ('1')
            if (valid(newRow, newCol, n, m) && a[newRow][newCol] == '1') {
                dfs(n, m, newRow, newCol, a);
            }
        }
        // Removed the premature return statement that was breaking the loop
    }
}