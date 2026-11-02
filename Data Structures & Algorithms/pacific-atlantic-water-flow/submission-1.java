
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // 1. DFS from Pacific borders (Top row and Left column)
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific, heights[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific, heights[0][j]);
        }
        
        // 2. DFS from Atlantic borders (Bottom row and Right column)
        for (int i = 0; i < m; i++) {
            dfs(heights, i, n - 1, atlantic, heights[i][n - 1]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, m - 1, j, atlantic, heights[m - 1][j]);
        }
        
        // 3. Find cells that can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;
        
        // Check boundaries, if already visited, or if current height is lower than previous (can't flow backwards)
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }
        
        // Mark as reachable from this ocean
        visited[r][c] = true;
        
        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};
        
        // Explore all 4 directions
        for (int k = 0; k < 4; k++) {
            dfs(heights, r + rowDir[k], c + colDir[k], visited, heights[r][c]);
        }
    }
}