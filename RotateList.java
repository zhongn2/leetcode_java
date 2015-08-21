/*
	实际上和rotate string 一样的原因是我们先让linkedlist的 end 连接上了头，
	然后去寻找新的头结点，并把尾巴节点指向空



*/
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode node = head;
        
        int len = 1;
        while(node.next != null){
            len++;
            node = node.next;
        }
        // node  现在是尾节点，而不是null
       node.next = head; 
        
        int m = len - (k % len);
        ListNode prehead = node;
        while(m > 0){
            prehead = prehead.next;
            m--;
        }
        // head 就是新的头结点
        head = prehead.next;
		//prehead就是尾节点
        prehead.next = null;
        
        
        return head;
    }
    
}
       
       
        