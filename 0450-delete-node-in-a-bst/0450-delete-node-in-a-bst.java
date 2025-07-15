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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;

        // if key is less ->go left
        if(key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if(key >root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        // Node to be deleted is found
        else {
            // case1 -> 0 child
            if(root.left == null && root.right == null) {
                return null;
            }

            // case2 -> child(right only)
            if(root.left==null && root.right!=null) {
                TreeNode temp = root.right;
                return temp;
            }

            // case2 -> child(left only)
            if(root.left!=null && root.right==null) {
                TreeNode temp = root.left;
                return temp;
            }

            // case 3 : 2 child

            // find inorder successor(min in right subtree)
            TreeNode successor = minValue(root.right);

            // replace current node's val with successor
            root.val = successor.val;

            // delete successor node from right sub tree
            root.right = deleteNode(root.right, successor.val);

            return root;
        }
    }

    private TreeNode minValue(TreeNode root) {
        TreeNode temp = root;
        while(temp.left!=null) {
            temp = temp.left;
        }
        return temp;
    }
}