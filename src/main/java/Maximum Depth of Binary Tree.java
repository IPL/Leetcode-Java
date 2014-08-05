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
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int depthLeft = maxDepth(root.left);
            int depthRight = maxDepth(root.right);
            return Math.max(depthLeft, depthRight) + 1;
        }
    }
}