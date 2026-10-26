class Solution {
    private Integer prev = null;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        // 1. Recursively check the left subtree
        if (!isValidBST(root.left)) {
            return false;
        }
        
        // 2. Check current node against the previous visited node
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        
        // 3. Recursively check the right subtree
        return isValidBST(root.right);
    }
}