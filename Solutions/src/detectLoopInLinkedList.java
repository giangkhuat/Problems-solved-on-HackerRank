/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next; ListNode(int x) { val
 * = x; next = null; } }
 */
public class detectLoopInLinkedList {
  public boolean hasCycle(ListNode head) {

    if (head == null) {
      return false;
    }
    ListNode run = head;
    ListNode walk = head;
    while (run != null && walk != null && run.next != null && run.next.next != null) {
      walk = walk.next;
      run = run.next.next;
      if (walk == run) {
        return true;
      }
    }
    return false;


  }
}
