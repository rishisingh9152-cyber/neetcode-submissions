class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to act as the starting anchor
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy; // Points to the end of our new merged list
        
        // While both lists have nodes left to compare
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;  // Attach list1's node
                list1 = list1.next; // Move list1 forward
            } else {
                tail.next = list2;  // Attach list2's node
                list2 = list2.next; // Move list2 forward
            }
            tail = tail.next;       // Move our tail forward
        }
        
        // Once one list is empty, attach whatever is left of the other list
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        
        // Return everything after the dummy node
        return dummy.next;
    }
}