class Solution {
    private TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        prev = null; // Reset for test case reuse
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        // 1. Traverse left subtree
        if (!inorder(root.left)) {
            return false;
        }
        
        // 2. Validate current node against previous node
        if (prev != null && root.val <= prev.val) {
            return false;
        }
        prev = root;
        
        // 3. Traverse right subtree
        return inorder(root.right);
    }
}