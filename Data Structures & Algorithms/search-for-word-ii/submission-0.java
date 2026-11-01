
class Solution {
    
    // Define the Trie Node using a HashMap for children
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null; // Stores the complete word at the end node
    }

    public List<String> findWords(char[][] board, String[] words) {
        // Step 1: Build the Trie using a HashMap
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (char c : w.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.word = w;
        }

        Set<String> result = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;

        // Step 2: Start DFS from every cell on the board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char ch = board[r][c];
                if (root.children.containsKey(ch)) {
                    dfs(board, r, c, root, result);
                }
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, Set<String> result) {
        char ch = board[r][c];

        // If the character path doesn't exist in the map, stop
        if (!parent.children.containsKey(ch)) {
            return;
        }

        TrieNode curr = parent.children.get(ch);

        // If we found a valid word, add it to the result set
        if (curr.word != null) {
            result.add(curr.word);
        }

        // 1. Choose: Mark current cell as visited by temporarily modifying it
        board[r][c] = '#';

        // 2. Explore: Check all 4 adjacent directions (Up, Down, Left, Right)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // Boundary check and ensure cell hasn't been visited in the current path
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] != '#') {
                dfs(board, nr, nc, curr, result);
            }
        }

        // 3. Un-choose (Backtrack): Restore the original character
        board[r][c] = ch;
    }
}