"""
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that
has both p and q as descendants (where we allow a node to be a descendant of itself).”

"""

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if ( p.val > root.val && q.val > root.val ){
            root = root.right;
            return lowestCommonAncestor(root, p, q);
        }

        if ( p.val < root.val && q.val < root.val ) {
            root = root.left;
            return lowestCommonAncestor(root, p, q);
        }

        return root;

    }
}