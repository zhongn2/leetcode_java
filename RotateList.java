// rotate is very similar with the string
 // the difference is we add two string together easier.
 // here we need to iterate the whole list and connect to be a circle
 // then move length - length % n to find the new head
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
       if(head == null || n == 0) return head;
       ListNode p = head;
       int len = 0;
       while(p.next != null){
           len++;
           p = p.next;
       }
        p.next = head; // connect the end with start
       int k = len - n % len; // find the new head position
       ListNode newhead = p;
	   
       while( k > 0){
           newhead = newhead.next;
           k--;
       }
       head = newhead.next;
       newhead.next = null;
       return head;
    }
}
       
       
        