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
    TreeNode pre;
    TreeNode first;
    TreeNode second;
     
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(pre == null){
            pre = root;
        }else{
            if(pre.val > root.val){
                if(first == null){
                    first = pre;
                }
                second = root;
            }
            pre = root;
        }
        inorder(root.right);
    }
     
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(first!=null && second!=null){        
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
}