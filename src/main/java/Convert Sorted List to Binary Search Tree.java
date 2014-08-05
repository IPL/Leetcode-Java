/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode node = head;
        while(node!=null){
            node = node.next;
            length++;
        }
        return sortedListToBST(head, length);
    }
    
    private TreeNode sortedListToBST(ListNode head, int length){
        if(length == 0 || head == null){
            return null;
        }else if(length == 1){
            return new TreeNode(head.val);
        }

        ListNode peak = head;
        int index = (int)(length/2);
        for(int i = 0; i<index; i++){
            peak = peak.next;
        }
        
        TreeNode node = new TreeNode(peak.val);
        node.left = sortedListToBST(head, index);
        node.right = sortedListToBST(peak.next, length - index - 1);
        
        return node;
    }
}