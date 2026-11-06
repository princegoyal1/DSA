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
    public boolean isValidBST(TreeNode root) {
        // return pre(root,Long.MIN_VALUE,Long.MAX_VALUE);
        return order(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    // private boolean pre(TreeNode root,long min,long max) {
    //     if(root==null) return true;
    //     if(root.val<=min || root.val>=max) return false;
    //     return pre(root.left,min,root.val) && pre(root.right,root.val,max);
    // }
    private boolean order(TreeNode root,long min,long max){
        if(root==null)return true;
        if(root.val<=min || root.val>=max)return false;
        if(!order(root.left,min,root.val))return false;
        if(root.left!=null && root.right!=null){
            if(root.left.val>=root.val || root.right.val<=root.val)return false;
        }
        else if(root.left!=null && root.right==null){
            if(root.left.val>=root.val)return false;
        }
        else if(root.right!=null && root.left==null){
            if(root.right.val<=root.val)return false;
        }
        if(!order(root.right,root.val,max))return false;
        return true;
    }
}