
public class deleteNodeInAList {
  public void deleteNode(ListNode node) {
    if (node == null) {
      return;
    }
    ListNode tmp = node;
    while (tmp.next != null) {
      tmp.val = tmp.next.val;
      if (tmp.next.next == null) {
        tmp.next = null;
      } else {
        tmp = tmp.next;
      }
    }
    return;
  }
}
