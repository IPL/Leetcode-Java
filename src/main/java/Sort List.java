/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        // security check
        if (head == null || head.next == null)
            return head;
 
        // split the list
        ListNode l = head;
        ListNode r = splitNodes(head);

        // now we have two parts l and r, recursively sort them
        ListNode h1 = sortList(l);
        ListNode h2 = sortList(r);
 
        // merge together
        ListNode merged = merge(h1, h2);
 
        return merged;
    }
    
    // Split the list in one pass
    ListNode splitNodes(ListNode pHead) {
        ListNode pNode = pHead;
        ListNode pNewHead = null;
        ListNode pNewNode = null;

        if (pNode != null) {
            pNewHead = pNewNode = pNode.next;
            pNode.next = pNewNode.next;
            pNode = pNode.next;
        }

        while (pNode != null && pNewNode != null) {
            pNewNode.next = pNode.next;
            pNewNode = pNewNode.next;
            if (pNewNode!=null) {
                pNode.next = pNewNode.next;
                pNode = pNode.next;
            }
        }

        return pNewHead;
    }
    
    public static ListNode merge(ListNode l, ListNode r) {
        ListNode p1 = l;
        ListNode p2 = r;
 
        ListNode fakeHead = new ListNode(0);
        ListNode pNew = fakeHead;
 
        while (p1 != null || p2 != null) {
 
            if (p1 == null) {
                pNew.next = p2;
                break;
            } else if (p2 == null) {
                pNew.next = p1;
                break;
            } else {
                if (p1.val < p2.val) {
                    pNew.next = p1; //O(1) space
                    p1 = p1.next;
                    pNew = pNew.next;
                } else if (p1.val == p2.val) {
                    pNew.next = p1;
                    p1 = p1.next;
                    pNew.next.next = p2;
                    p2 = p2.next;
                    pNew = pNew.next.next;
                } else {
                    pNew.next = p2;
                    p2 = p2.next;
                    pNew = pNew.next;
                }
            }
        }
 
        return fakeHead.next;
    }
}