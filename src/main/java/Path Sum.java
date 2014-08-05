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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        sum -= root.val;
        if( root.left == null      // must be leaf node
            && root.right == null 
            && sum == 0)
            return true;
        else{
            return (hasPathSum(root.left, sum) 
                || hasPathSum(root.right, sum));
        }
    }
}