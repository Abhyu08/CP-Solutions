import javax.swing.tree.TreeNode;




class Solution {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean check_symmetry(TreeNode left , TreeNode right){


        //check
        if(left.val != right.val)
            return false;
        else return true;

    }
    public boolean traverse_tree(TreeNode left , TreeNode right){

        //sout
        //       if(left != null)
        //              System.out.println("left  -- > "+left.val);
        //       else
        //              System.out.println("left  -- > null");
        //       if(right != null)
        //               System.out.println("right -- > "+right.val);
        //        else
        //                System.out.println("right -- > null");
        //check
        if(left == null && right == null)
            return true;
        else if(left == null && right != null)
            return false;
        else if(left != null && right == null)
            return false;
        //recursive
        boolean flag = check_symmetry(left , right);
        boolean tmp1 = traverse_tree(left.left , right.right);

        boolean tmp2 = traverse_tree(left.right , right.left);

        if(flag == false || tmp1 == false || tmp2 == false)
            return false;
        else
            return true;
    }

    public boolean isSymmetric(TreeNode root) {
        boolean flag = traverse_tree(root.left , root.right);
        return  flag ;
    }
}