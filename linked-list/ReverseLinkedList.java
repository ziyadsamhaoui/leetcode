"""
Given the head of a singly linked list, reverse the list, and return the reversed list.
"""

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode next = null;
        ListNode current = head;

        while( current != null ){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}