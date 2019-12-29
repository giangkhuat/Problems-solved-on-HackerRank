/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class deleteElementsInLinkedList{
    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev =  fakeHead;

        while (current != null) {
         if (current.val == val) {
             prev.next = current.next; 
         } else {
             prev = prev.next;
         }
            current = current.next;
        }
        return fakeHead.next;
        
    }
}
