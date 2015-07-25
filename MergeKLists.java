/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       if(lists.length == 0) return null;
       return mergeHelper(lists, 0,lists.length - 1);
    }
    // divide into two parts and then merge 
    private ListNode mergeHelper(ListNode[] lists, int start, int end){
       if(start == end) return lists[0];
        int mid = (end - start) + start / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        // new a listnode to be the new listnode
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        
        if(l1 != null){
            node.next = l1;
        }else{
            node.next = l2;
        }
        
        return dummy.next;
  
    }
    
    
}