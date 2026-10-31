class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        return searchAtTree(word, 0, root);
    }

    private boolean searchAtTree(String word, int i, TrieNode node) {
        // Base case: if node is null, path doesn't exist
        if (node == null) {
            return false;
        }
        
        // Base case: if we've reached the end of the word, check if it's a valid word ending
        if (i == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(i);
        
        if (c == '.') {
            // Wildcard: Try all 26 possible child paths. If any returns true, return true.
            for (int k = 0; k < 26; k++) {
                if (searchAtTree(word, i + 1, node.children[k])) {
                    return true;
                }
            }
            return false;
        } else {
            // Normal character: Go to the specific child index
            int index = c - 'a';
            return searchAtTree(word, i + 1, node.children[index]);
        }
    }
}