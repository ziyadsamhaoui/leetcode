"""
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
"""

public class Solution {
    // List approach
    public boolean hasCycle(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>();
        ListNode current = head;

        while( current != null){
            if(nodeList.contains(current)){
                return true;
            } else {
                nodeList.add(current);
                current = current.next;
            }
        }

        return false;
    }

    // Floyd cycle detection
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            """
            slow → moves 1 node at a time
            fast → moves 2 nodes at a time
            Once both pointers enter the cycle, fast is moving twice as quickly as slow.
            Therefore, fast will eventually catch slow.
            """
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

}