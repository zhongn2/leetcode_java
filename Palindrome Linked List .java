/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is the middle node
        // split the linkedlist to two parts
        ListNode tmp = slow.next;
        slow.next = null;
        // reverse the other half
        ListNode newList = reverse(tmp);
        ListNode node = head;
        while(newList != null){
            if(node.val != newList.val){
                return false;
            }
            node = node.next;
            newList = newList.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode node){
        ListNode prev = null;
        while(node != null){
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        return prev;
        
    }
}