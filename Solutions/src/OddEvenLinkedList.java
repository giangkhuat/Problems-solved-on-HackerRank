
public class OddEvenLinkedList {
   
  public ListNode oddEvenList(ListNode head) {
    if (head == null) {
        return head;
    }
    
    ListNode odd = head;
    ListNode evenHead = odd.next;
    ListNode evenPointer = evenHead;
    while (evenPointer != null && evenPointer.next != null) {
     odd.next = evenPointer.next;
     odd = odd.next;
    evenPointer.next = odd.next;
    evenPointer = evenPointer.next;
    }
    odd.next = evenHead;
    return head;
}
}
