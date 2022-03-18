import java.util.ArrayList;
import java.util.Stack;


class Solution {


     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }




    //O(1) Space O(n) Time
    //Using Arrays
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean flag = true;
        while(head !=null){
            list.add(head.val);
            head = head.next;
        }
        int length = list.size();
        for(int i=0;i<length/2;i++){
            if(list.get(i) != list.get(length - i - 1)){
                flag = false;
                break;
            }
        }
        if(flag)
            return true;
        else return false;
    }


    //Recursion
    ListNode traverse = null ;
    public boolean recursion(ListNode current){

        if(current == null){
            return true;
        }

        boolean flag = recursion(current.next);
        if(traverse.val != current.val){
            return false;
        }else{
            traverse = traverse.next;
        }
        return flag;
    }
    public boolean isPalindrome5(ListNode head) {
        traverse = head;
        return recursion(head);
    }


    //Stack
    public boolean isPalindrome4(ListNode head) {
        Stack<Integer> stk = new Stack<>();
        ListNode current = head;
        int length = 0;

        //length
        while(current!=null){
            stk.push(current.val);
            current = current.next;
            length++;
        }
        current = head;
        length /=2;
        while(stk.empty() != true && length-->0){
            if(stk.pop() != current.val){
                return false;
            }else{
                current = current.next;
            }
        }
        return true;
    }



    //Brute Force 
    public boolean isPalindrome2(ListNode head) {
        ListNode current = head;
        ListNode temp = head;
        int length = 0;

        //length
        while(current!=null){
            current = current.next;
            length++;
        }
        int iterate = length/2;
        current = head;

        for(int i=0;i<iterate;i++){
            int skip = length - i - 1;
            temp = head;
            while(skip-->0)
                temp = temp.next;
            if(temp.val != current.val)
                return false;
            else
                current = current.next;
        }

        return true;

    }
}