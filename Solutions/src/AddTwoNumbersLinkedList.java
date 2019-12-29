
/*
 * public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pointerFirst = l1;
        ListNode pointerSec = l2;
        ListNode result = dummy;
        int sum = 0, carryon = 0;
        while (pointerFirst != null || pointerSec != null) {
            System.out.println("sum = " + sum);
            System.out.println("carryon= " + carryon);
            sum = sum + carryon;
            
            if (pointerFirst != null) {
                sum = sum + pointerFirst.val;
                pointerFirst = pointerFirst.next;
            }
            if (pointerSec != null) {
                sum = sum + pointerSec.val;
                pointerSec = pointerSec.next;
            }
            result.next = new ListNode(sum %10);
            result  = result.next;
            carryon = sum / 10;
            sum = 0;
            
            
        }
        if (carryon != 0) {
            result.next = new ListNode(carryon);
        }
        return dummy.next;
    }
 */

public class AddTwoNumbersLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
}