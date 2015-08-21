/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        
        while(n > 0){
            head = head.next;
            n--;
        }
        while(head != null){
            head = head.next;
            prev = prev.next; // find the node before deleting node
        }
        prev.next = prev.next.next;
        return dummy.next;

    }
}