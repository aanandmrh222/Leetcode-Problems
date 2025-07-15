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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(root, arr);
        
        int left = 0;
        int right = arr.size()-1;

        while(left < right) {
            int sum = arr.get(left) + arr.get(right);
            if(sum == k) return true;
            else if(sum < k) left++;
            else right--;
        }
        return false;
    }

    private void inOrder(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) return;
        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
    }
}