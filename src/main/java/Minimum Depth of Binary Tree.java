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
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int depthLeft = minDepth(root.left);
            int depthRight = minDepth(root.right);
            if (depthLeft == 0 || depthRight == 0)
                return 1 + depthLeft + depthRight;
            else
                return Math.min(depthLeft, depthRight) + 1;
        }
    }
}