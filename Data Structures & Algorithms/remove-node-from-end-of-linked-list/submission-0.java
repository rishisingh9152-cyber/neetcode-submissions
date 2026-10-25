class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Use a dummy node to safely handle edge cases (like removing the head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 1. Find the total length of the linked list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next; // <-- Fixed: Moved pointer forward to avoid infinite loop
        }
        
        // 2. Calculate how many steps to take from the dummy node
        // to reach the node *right before* the one we want to delete
        int stepsToTarget = length - n;
        current = dummy;
        
        for (int i = 0; i < stepsToTarget; i++) {
            current = current.next;
        }
        
        // 3. Remove the target node
        current.next = current.next.next; // <-- Fixed: Using correct deletion logic
        
        // 4. Return the new head
        return dummy.next;
    }
}