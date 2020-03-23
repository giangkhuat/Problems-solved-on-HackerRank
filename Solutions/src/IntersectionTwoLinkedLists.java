/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
Step1: Find the size of A and B
Step2: advance the longest list until they are the same size.
Step3: search until you find the intersection
Step4: return either of the nodes, as they are pointing to the intersection.
*/
public class IntersectionTwoLinkedLists {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    if (headA == null || headB == null) {
      return null;
    }

    int sizeA = 0;
    int sizeB = 0;

    ListNode pointerA = headA;
    ListNode pointerB = headB;

    while (pointerA != null) {
      pointerA = pointerA.next;
      sizeA++;
    }

    while (pointerB != null) {
      pointerB = pointerB.next;
      sizeB++;
    }

    pointerA = headA;
    pointerB = headB;


    if (sizeA > sizeB) {
      while (sizeA > sizeB) {
        pointerA = pointerA.next;
        sizeA--;
      }
    } else if (sizeA < sizeB) {
      while (sizeB > sizeA) {
        pointerB = pointerB.next;
        sizeB--;
      }
    }

    while (pointerA != null && pointerB != null) {
      if (pointerA.equals(pointerB)) {
        return pointerA;
      }
      pointerA = pointerA.next;
      pointerB = pointerB.next;
    }
    return null;

  }
}
