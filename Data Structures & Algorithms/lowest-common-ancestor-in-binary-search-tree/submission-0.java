/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null, or we found either p or q
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Recursively search left and right subtrees
        TreeNode leftFound = lowestCommonAncestor(root.left, p, q);
        TreeNode rightFound = lowestCommonAncestor(root.right, p, q);
        
        // If p and q were found in separate branches, current root is the LCA
        if (leftFound != null && rightFound != null) {
            return root;
        }
        
        // Otherwise, return whichever side found something (or null if neither)
        return leftFound != null ? leftFound : rightFound;
    }
}