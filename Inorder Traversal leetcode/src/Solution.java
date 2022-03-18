import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;


class Solution {

    // Definition for a binary tree node.
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
    
    public void Inorder_traversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            Inorder_traversal(node.left, list);
            list.add(node.val);
            Inorder_traversal(node.right, list);

        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Inorder_traversal(root, list);
        return list;

    }
}