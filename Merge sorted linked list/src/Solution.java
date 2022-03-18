import java.util.Scanner;

public class Solution {

    public static ListNode head1 = null;
    public static ListNode head2 = null;


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode head = null;
//        //head
//        if (list1 != null && list2 != null) {
//            if (list1.val < list2.val)
//                head = list1;
//            else
//                head = list2;
//        } else if (list2 == null && list1 != null) {
//            head = list1;
//        } else if (list1 == null && list2 != null) {
//            head = list2;
//        } else if (list1 == null && list2 == null)
//            return head;
//
//        ListNode current = null;
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                if (current == null){
//                    current = list1;
//                    list1 = list1.next;
//                    continue;
//                }
//                else
//                    current.next = list1;
//                current = current.next;
//                list1 = list1.next;
//            } else {
//                if (current == null){
//                    current = list2;
//                    list2 = list2.next;
//                    continue;
//                }
//                else
//                    current.next = list2;
//                current = current.next;
//                list2 = list2.next;
//            }
//        }
////        head = head.next;
//        while (list1 != null) {
//            current.next = list1;
//            current = current.next;
//            list1 = list1.next;
//        }
//        while (list2 != null) {
//            current.next = list2;
//            current = current.next;
//            list2 = list2.next;
//        }
//        current.next = null;
//        return head;
//    }
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head = null;
    //head
    if (list1 != null && list2 != null) {
        if (list1.val < list2.val)
            head = list1;
        else
            head = list2;
    } else if (list2 == null && list1 != null) {
        head = list1;
        return head;
    } else if (list1 == null && list2 != null) {
        head = list2;
        return head;
    } else if (list1 == null && list2 == null)
        return head;

    ListNode current = null;
    while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
            if (current == null){
                current = list1;
                list1 = list1.next;
                continue;
            }
            else
                current.next = list1;
            current = current.next;
            list1 = list1.next;
        } else {
            if (current == null){
                current = list2;
                list2 = list2.next;
                continue;
            }
            else
                current.next = list2;
            current = current.next;
            list2 = list2.next;
        }
    }
//        head = head.next;
    while (list1 != null) {
        current.next = list1;
        current = current.next;
        list1 = list1.next;
    }
    while (list2 != null) {
        current.next = list2;
        current = current.next;
        list2 = list2.next;
    }
    current.next = null;
    return head;
}

    public ListNode insert(int data, int position, ListNode head) {
        ListNode node = new ListNode(data, null);
        ListNode current = head;
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
        return head;
    }

    public void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sl = new Solution();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            head1 = sl.insert(i + 1, i + 1, head1);
        }
        sl.display(head1);
        for (int i = 0; i < n; i++) {
            head2 = sl.insert(i + 1 + n - 3, i + 1, head2);
        }
        sl.display(head2);
        ListNode head = null;
        head = sl.mergeTwoLists(head1, head2);
        sl.display(head);
    }
}
