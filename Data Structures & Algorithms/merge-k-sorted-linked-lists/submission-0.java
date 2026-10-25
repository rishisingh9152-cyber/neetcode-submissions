

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        // Min-heap to store the current head of each list, ordered by node value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // 1. Add the head of each non-null list into the heap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        // 2. Extract the minimum node and push its next node into the heap
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            tail.next = smallest;
            tail = tail.next;
            
            // If there is a next node in that list, add it to the heap
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }
        
        return dummy.next;
    }
}