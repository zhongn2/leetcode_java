// the solution takes some time to figure out
// we know that if there is a common part in the intersection
// we should know the diff between two linked list

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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        int diff = Math.abs(lenA - lenB);
        return lenA > lenB ? getNode(headB, headA, diff) : getNode(headA, headB, diff);  
    }
	// we make sure that headA is always greater than headB, so the new function is only for one condition, but we 
	// can choose different parameters
    public ListNode getNode(ListNode h1, ListNode h2, int len){
        ListNode result = new ListNode(-1);
            while(len > 0){
                h2 = h2.next;
                len--;
            }
            while(h1 != null && h2 != null){
               
                    if(h1.val == h2.val){
                        result = h1;
                        break;
                    }
                    h1 = h1.next;
                    h2 = h2.next;
            }
			// reach the end of both linkedlists
            if(h1 == null || h2 == null){
                return null;
            }
            
            return result;
    }
   
    public int getLength(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
    
}