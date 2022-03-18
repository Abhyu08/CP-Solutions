import javax.swing.tree.TreeNode;


class Solution {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int calculate_diameter(TreeNode node, int[] length) {
        if (node == null) {
            return 0;
        } else {
            int left = calculate_diameter(node.left, length);
            int right = calculate_diameter(node.right, length);

            // length = Math.max(length , left);
            // length = Math.max(length, right);
            length[0] = Math.max(left + right, length[0]);
            return Math.max(left, right) + 1;
        }

    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] length = new int[1];
        int left = calculate_diameter(root, length);
        return length[0];
    }
}