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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null)
            queue.add(root);
        int leftCount = 0;
        int depth = 0;
        while(!queue.isEmpty()){
            if(leftCount == 0){
                depth++;
                list = new ArrayList<Integer>();
                res.add(list);
                leftCount = queue.size();
            }
            TreeNode node = queue.poll();
            if (depth % 2 == 0) {
                list.add(0, node.val);
            } else { 
                list.add(node.val);
            }
            leftCount--;
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
        return res;
    }
}