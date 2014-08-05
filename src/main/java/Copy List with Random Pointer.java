/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        CloneNodes(head);
        ConnectSiblingNodes(head);
        return ReconnectNodes(head);
    }
    
    // Clone all nodes in a complex linked list with head pHead, 
    // and connect all nodes with m_pNext link
    // 1 -> 2 -> 3
    // |_________|
    //
    // 1 -> 1' -> 2 -> 2' -> 3 -> 3'
    // |_____________________|
    static void CloneNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCloned = new RandomListNode(0);

            pCloned.label = pNode.label;
            pCloned.next = pNode.next;
            pCloned.random = null;

            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }

    // Connect sibling nodes in a complex link list

    // 1 -> 2 -> 3
    // |_________|
    //      ______________________ 
    //      |                     |
    // 1 -> 1' -> 2 -> 2' -> 3 -> 3'
    // |_____________________|
    void ConnectSiblingNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCloned = pNode.next;
            if (pNode.random != null)
                pCloned.random = pNode.random.next;
            pNode = pCloned.next;
        }
    }

    // Split a complex list into two: Reconnect nodes 
    // to get the original list,
    // and its cloned list
    //      ______________________ 
    //      |                     |
    // 1 -> 1' -> 2 -> 2' -> 3 -> 3'
    // |_____________________|

    // 1 -> 2 -> 3
    // |_________|

    // 1' -> 2' -> 3'
    // |___________|
    RandomListNode ReconnectNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;

        if (pNode != null) {
            pClonedHead = pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        while (pNode != null) {
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        return pClonedHead;
    }
}