class PrefixTree {
    private static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26]; // For lowercase English letters 'a' through 'z'
            isEnd = false;
        }
    }

    private final TrieNode root;
  

    public PrefixTree() {
        
        root=new TrieNode ();
    }

    public void insert(String word) {
       
       TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;

    }
    private TrieNode searchPrefixNode(String str) {
        TrieNode curr = root;
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                return null;
            }
            curr = curr.children[index];
        }
        return curr;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefixNode(word);
        return node != null && node.isEnd;

    }

    public boolean startsWith(String prefix) {
        return searchPrefixNode(prefix) != null;


    }
}
