class Solution {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        calculateMaxGain(root);
        return maxSum;
    }

    private int calculateMaxGain(TreeNode root) {
        // Base case: if node is null, it contributes 0 to the path sum
        if (root == null) {
            return 0;
        }

        // Recursively get the maximum gain from left and right subtrees.
        // Math.max(0, ...) ensures we ignore negative paths (treat them as 0).
        int leftGain = Math.max(0, calculateMaxGain(root.left));
        int rightGain = Math.max(0, calculateMaxGain(root.right));

        // 1. Price of a path where the current node is the highest point (apex)
        int currentPathSum = root.val + leftGain + rightGain;

        // 2. Update the global maximum path sum found so far
        maxSum = Math.max(maxSum, currentPathSum);

        // 3. Return the maximum gain the current node can add to its parent 
        // (A parent can only continue the path down ONE branch, so we pick the max)
        return root.val + Math.max(leftGain, rightGain);
    }
}