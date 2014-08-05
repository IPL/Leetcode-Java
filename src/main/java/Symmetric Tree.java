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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) 
            return true;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root.left);
        s2.push(root.right);
        while (!s1.empty() && !s2.empty()) {
            TreeNode n1 = s1.pop();
            TreeNode n2 = s2.pop();
            if (n1 == null && n2 == null) 
                continue;
            if (n1 == null || n2 == null) 
                return false;
            if (n1.val != n2.val) 
                return false;
            s1.push(n1.left);
            s2.push(n2.right);
            s1.push(n1.right);
            s2.push(n2.left);
        }
        return true;
    }

}