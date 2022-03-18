import java.util.Scanner;

public class Solution {
    public LinkedNode head = null;

    public class LinkedNode {
        int data;
        LinkedNode next;

        LinkedNode() {
        }

        LinkedNode(int data) {
            this.data = data;
        }

        LinkedNode(int data, LinkedNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public void insert(int data, int position) {
        LinkedNode node = new LinkedNode(data, null);
        LinkedNode current = head;
        if (position == 1) {
            node.next = head;
            head = node;
        } else {
            position -= 3;
            while (current != null && position >= 0) {
                position--;
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
    }

    public void display() {
        LinkedNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sl = new Solution();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            sl.insert(i + 1, i + 1);
        }
        sl.display();
    }
}
