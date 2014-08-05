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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        } else {
            Stack<TreeNode> sTraverse = new Stack<TreeNode>();
            sTraverse.push(root);
            while(!sTraverse.isEmpty()) {
                TreeNode top = sTraverse.pop();
                result.add(0, top.val);
                if (top.left != null)
                    sTraverse.push(top.left);
                if (top.right != null)
                    sTraverse.push(top.right);
            }
            return result;
        }
    }
}