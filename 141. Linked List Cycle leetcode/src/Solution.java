
public class Solution {

    
     // Definition for singly-linked list.
      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }


    ListNode result = null;
    public void findCycle(ListNode node1 ,ListNode node2){
        if(node1 == null || node2 == null){
            return ;
        }else if(result == null){
            if(node1 == node2){
                result =  node1;
            }else if (node1.next != null && node2.next != null){
                findCycle(node1.next , node2.next.next);
            }
        }
    }

    public boolean hasCycle(ListNode head ) {
        if(head != null)
            findCycle(head , head.next);
        return result == null ? false : true;
    }
}