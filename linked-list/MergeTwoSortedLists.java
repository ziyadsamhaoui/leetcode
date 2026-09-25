"""
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
"""

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // node that points at the very start of the linked list, used as a starting point
        ListNode node = new ListNode(0);
        ListNode current = node;

        while( list1 != null && list2 != null){

            if(list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // append the rest of the list if any of them is not null
        if(list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // points at the head of the linked list
        return node.next;
    }
}