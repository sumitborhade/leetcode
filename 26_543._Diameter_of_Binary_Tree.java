/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depthOfTree(root);
        return max == 0 ? 0 : max-1;
    }
    
    public int depthOfTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = depthOfTree(root.left);
        int right = depthOfTree(root.right);
        
        int maxDepth = Math.max(left, right) + 1;
        max = Math.max(max, left + right + 1);
        return maxDepth;
    }
}
