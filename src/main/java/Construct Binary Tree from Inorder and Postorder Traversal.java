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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inEnd = inorder.length-1;
        int postStart =0;
        int postEnd = postorder.length-1;
 
        return buildTree(inorder, inStart, inEnd, 
                     postorder, postStart, postEnd);
    }
    
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, 
                            int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd)
            return null;
 
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
 
        int k=0;
        for(int i=0; i< inorder.length; i++){
            if(inorder[i]==rootValue){
                k = i;
                break;
            }
        }
 
        // Becuase k is not the length, it it need to -(inStart+1) to get 
        // the length
        root.left = buildTree(inorder, inStart, k-1, 
                          postorder, postStart, postStart+k-(inStart+1));
        // postStart+k-inStart = postStart+k-(inStart+1) +1
        root.right = buildTree(inorder, k+1, inEnd, 
                           postorder, postStart+k-inStart, postEnd-1);
 
        return root;
    }
}