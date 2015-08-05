/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 // this question contains several situations
 // we have to define a dummy node and move the node
 // return dummy.next as the result
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
             return null;
        }
        
        ListNode newhead = new ListNode(-1);
        ListNode move = newhead;
        int carry = 0;
        while(l1 != null && l2 != null){
           int sum = l1.val + l2.val + carry; // carry should be added in the sum
           move.next = new ListNode(sum % 10);
           carry = sum / 10;
           l1 = l1.next;
           l2 = l2.next;
           move = move.next;
        }
        // when l1 is bigger
        while(l1 != null){
           // don't forget the carry
           int sum = l1.val + carry;
           move.next = new ListNode(sum % 10);
           carry = sum / 10;
           l1 = l1.next;
           move = move.next;
        }
        // when l2 is bigger
        while(l2 != null){
           // don't forget the carry
           int sum = l2.val + carry;
           move.next = new ListNode(sum % 10);
           carry = sum / 10;
           l2 = l2.next;
           move = move.next;
        }
		// reach the end and it turns out sum > 10
        if(carry != 0){
            move.next = new ListNode(1);
        }
            
        return newhead.next;  
    }
}