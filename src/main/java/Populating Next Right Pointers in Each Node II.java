/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode node;
        TreeLinkNode pre = null, curr = null;
        while (root != null) {
            node = root;
            pre = null;
            curr = null;
            while (node != null) {
                if (node.left != null && curr != node.left) 
                    curr = node.left;
                else if (node.right != null) 
                    curr = node.right;
                if (pre != null) {
                    if (pre != curr)
                        pre.next = curr;
                } else 
                    root = curr;
                pre = curr;
                if (node.right == null || curr == node.right) 
                    node = node.next;
            }
        }
    }
}