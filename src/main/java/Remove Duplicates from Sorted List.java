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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        else {
            ListNode tempPrevious = head;
            ListNode temp = head.next;
            while(tempPrevious!=null && temp!=null){
                if (tempPrevious.val == temp.val) {
                    tempPrevious.next = temp.next;
                    temp = temp.next;
                } else {
                    temp = temp.next;
                    tempPrevious = tempPrevious.next;
                }
            }
            return head;
        }
    }
}