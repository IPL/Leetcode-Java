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
    public void flatten(TreeNode root) {
        getTailAndFlatten(root);
    }
    
    private TreeNode getTailAndFlatten(TreeNode tail){
        if(tail == null 
           || tail.left == null 
			  && tail.right == null)
            return tail;
        TreeNode right = tail.right;
        TreeNode left = tail.left;
        TreeNode rightTail = getTailAndFlatten(tail.right);
        TreeNode leftTail = getTailAndFlatten(tail.left);
        
        if (left == null) {
            return rightTail;
        } else if (right == null) {
            tail.left = null;
            tail.right = left;
            return leftTail;
        } else {
            tail.left = null;
            tail.right = left;
            leftTail.right = right;
            return rightTail;
        } 
    }
}