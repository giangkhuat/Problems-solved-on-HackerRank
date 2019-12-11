/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class reverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev, current, next;
        prev = null;
        current  = head;
        while (current != null) {
            System.out.println("Val = " + current.val);
            next = current.next;
            current.next = prev;
            prev = current; 
            current = next;
        }
        head = prev;
        return head;
    }
}