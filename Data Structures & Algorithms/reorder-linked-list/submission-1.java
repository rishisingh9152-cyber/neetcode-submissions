class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        // --- STEP 1: Find the middle and split ---
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;          // 1 step
            fast = fast.next.next;     // 2 steps
        }
        
        // --- STEP 2: Reverse the second half ---
        ListNode prev = null;
        ListNode current = slow.next;
        slow.next = null; // Cut the link to separate the two halves
        
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        
        // --- STEP 3: Merge the two halves alternately ---
        ListNode first = head;
        ListNode second = prev; // 'prev' is now the head of the reversed second half
        
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            
            first.next = second;    // Point first to second
            second.next = temp1;    // Point second to the next node of first
            
            first = temp1;          // Move first pointer forward
            second = temp2;         // Move second pointer forward
        }
    }
}