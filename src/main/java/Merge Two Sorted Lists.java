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
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else {
            ListNode head;
            ListNode tail;
            if (l1.val < l2.val) {
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }
            tail = head;
            while(l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    tail.next = l1;
                    tail = tail.next;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    tail = tail.next;
                    l2 = l2.next;
                }
            }
            if (l1 != null) {
                tail.next = l1;
            } else if (l2 != null) {
                tail.next = l2;
            }
            return head;
        }
    }
}