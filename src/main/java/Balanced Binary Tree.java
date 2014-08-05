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
    public boolean isBalanced(TreeNode root) {
        boolean []flag = new boolean[1];
        flag[0] = true;
        if (root == null)
            return true;
        else {
            int leftDepth = getDepth(root.left, flag);
            if (!flag[0])
                return false;
            int rightDepth = getDepth(root.right, flag);
            if (!flag[0])
                return false;
            if (Math.abs(leftDepth - rightDepth) > 1)
                return false;
            else {
                return true;
            }
        }
    }
    
    int getDepth(TreeNode root, boolean[] flag) {
        if (root == null)
            return 0;
        else {
            int leftDepth = getDepth(root.left, flag);
            int rightDepth = getDepth(root.right, flag);
            if (Math.abs(leftDepth - rightDepth) > 1) {
                flag[0] = false;
                return -1;
            }
            return Math.max(leftDepth, rightDepth)+1;
        }
    }
}