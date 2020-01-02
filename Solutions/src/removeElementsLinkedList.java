
public class removeElementsLinkedList {
  public ListNode removeElements(ListNode head, int val) {
    ListNode current = head;
    ListNode fakeHead = new ListNode(0);
    fakeHead.next = head;
    ListNode prev = fakeHead;

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
