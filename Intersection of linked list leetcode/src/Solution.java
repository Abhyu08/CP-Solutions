
public class Solution {


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        if(headA == null || headB == null)
            return null;

        while(pointerA != pointerB){

            if(pointerB == null){
                pointerB = headA;
            }else{
                pointerB = pointerB.next;
            }

            if(pointerA == null){
                pointerA = headB;
            }else{
                pointerA = pointerA.next;
            }
        }
        return pointerA;
    }



    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode lst1 = headA;
        ListNode lst2 = headB;
        if (headA == null || headB == null) {
            return null;
        }
        int length1 = 0;
        int length2 = 0;
        //length start
        while (lst1 != null) {
            length1++;
            lst1 = lst1.next;
        }
        while (lst2 != null) {
            length2++;
            lst2 = lst2.next;
        }
        //length end

        //skip extra's start
        lst1 = headA;
        lst2 = headB;
        if (length1 > length2) {
            length1 -= length2;
            while (length1 > 0) {
                lst1 = lst1.next;
                length1--;
            }
        } else {
            length2 -= length1;
            while (length2 > 0) {
                lst2 = lst2.next;
                length2--;
            }
        }
        //skip extra's end
        if (lst1 == lst2) {
            return lst1;
        }
        while (lst1 != null || lst2 != null) {
            lst1 = lst1.next;
            lst2 = lst2.next;

            if (lst1 == lst2) {
                return lst1;
            }
        }
        return null;
    }
}