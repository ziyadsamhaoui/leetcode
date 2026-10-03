"""
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.
"""

class Solution {
    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> listOfNodes = new ArrayList<>();
        ListNode current = head;
        int middleIndex = 0;

        while( current != null ){
            listOfNodes.add(current);
            current = current.next;
        }

        ListNode middleNode = listOfNodes.get(listOfNodes.size() / 2);

        return middleNode;
    }
}