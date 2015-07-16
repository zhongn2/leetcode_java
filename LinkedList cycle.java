/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 // we have two pointers called slow and fast
 // if there is a cycle in the linkedlist, slow will meet fast(no cycle return null)
 // fast's speed is double as slow so the total length will double as well
 // 2(a + b) = 2b + a + c;
 // we know a = c
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(true){
            if(fast == null || fast.next == null) return null; // no cycle in the linked list
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        // 2(a+b) = a + c + 2b;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}