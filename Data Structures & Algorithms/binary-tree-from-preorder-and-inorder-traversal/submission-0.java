
class Solution {
    private Map<Integer, Integer> inorderMap;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inorderIndex = 0;
        inorderMap = new HashMap<>();
        
        // Map values to their indices for O(1) lookups
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        // Base case: if there are no elements to construct subtrees
        if (left > right) {
            return null;
        }

        // 1. Get the current root value from preorder and advance the index
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // 2. Find the root's index in the inorder array to split subtrees
        int mid = inorderMap.get(rootVal);

        // 3. Recursively build left and right subtrees
        // Note: Must build the left subtree first because preorder visits root -> left -> right
        root.left = helper(preorder, left, mid - 1);
        root.right = helper(preorder, mid + 1, right);

        return root;
    }
}