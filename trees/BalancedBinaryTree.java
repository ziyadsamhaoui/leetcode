"""
Given a binary tree, determine if it is height-balanced.
"""

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){ return true; }

        if(!isBalanced(root.left)) { return false; }

        if(!isBalanced(root.right)) { return false; }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return ( Math.abs(leftHeight - rightHeight) <= 1 ? true : false );
    }

    public int height(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}