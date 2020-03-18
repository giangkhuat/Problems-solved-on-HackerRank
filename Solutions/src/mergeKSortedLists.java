/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
/*
 * ListNode[] lst:
 * [[1, 2, 3]
 * [1,4,5]
 * [2,6]]
 * Put all first nodes in each list in the min heap /queue
 * pop queue, get the smallest value
 * Put the next smallest value in that row in the queue
 */
class mergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0 || (lists.length == 1 && lists[0] == null)) {
      return null;
    }

    int size = lists.length;
    PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);

    for (int i = 0; i < size; i++) {
      if (lists[i] != null) {
        pq.offer(lists[i]);
      }
    }

    ListNode fakeHead = null;
    ListNode pointer = null;

    while (!pq.isEmpty()) {
      ListNode val = pq.poll();
      if (fakeHead == null) {
        fakeHead = val;
        pointer = fakeHead;
      } else {
        pointer.next = val;
        pointer = pointer.next;
      }
      if (val.next != null) {
        pq.add(val.next);
      }
    }

    return fakeHead;


  }
}
