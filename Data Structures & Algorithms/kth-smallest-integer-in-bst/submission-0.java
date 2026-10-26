

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // Create a Max-Heap (largest element is at the top)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Traverse the tree and populate the heap
        traverse(root, maxHeap, k);
        
        // The top of the max-heap is the kth smallest element
        return maxHeap.peek();
    }
    
    private void traverse(TreeNode root, PriorityQueue<Integer> maxHeap, int k) {
        if (root == null) {
            return;
        }
        
        // Add current node to the heap
        maxHeap.offer(root.val);
        
        // If heap size exceeds k, remove the largest element
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }
        
        // Recursively visit left and right children
        traverse(root.left, maxHeap, k);
        traverse(root.right, maxHeap, k);
    }
}