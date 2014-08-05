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
    public boolean isValidBST(TreeNode root) {
        return isValidBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);        
    }
    
    private boolean isValidBst(TreeNode root, int min, int max){
        if(root == null){
            return true;
        } else if(root.val <= min || root.val >= max){
            return false;
        } else{
            return isValidBst(root.left, min, root.val) 
				   && isValidBst(root.right, root.val, max);
        }
    }
}