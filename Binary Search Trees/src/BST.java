import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;

    }
}

public class BST {

    public static int getHeight(Node root) {
        int lheight = 0;
        int rheight = 0;
        if (root == null)
            return 0;
        if (root.left != null)
            lheight += getHeight(root.left) + 1;
        if (root.right != null)
            rheight += getHeight(root.right) + 1;
        return Math.max(lheight, rheight);
    }


    public static Node insert(Node root, int data) {
        Node current = root;
        if (root == null) {
            return new Node(data);
        } else if (data > root.data) {
            current = insert(root.right, data);
            root.right = current;
        } else {
            current = insert(root.left, data);
            root.left = current;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        Node root = null;
        while (numbers-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        System.out.println("Highest Height  = " + getHeight(root));
    }
}
