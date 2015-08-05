
/*
这道题，如果使用linkedhashmap，因为传入的数字是有序的，所以删除和加入完全不影响order
但是如果只是hashmap，没有办法track顺序，只能用双向链表记录改变的Node的前后指针


*/


public class LRUCache {
    private class Node{
        int key;
        int value;
        Node prev;// 前节点
        Node next;// 后节点，便于删除使用
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;// initialization
            this.next = null;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> LRU = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    // get the Node of specific key and move it to the tail
    public int get(int key) {
        if(!LRU.containsKey(key)){
            return -1;
        }
        Node curr = LRU.get(key);
        curr.prev.next = curr.next; // doublely linked list
        curr.next.prev = curr.prev;
        // move curr to tail
        move_to_tail(curr);
        return LRU.get(key).value;
    }
    
    public void set(int key, int value) {
        // the node exists
        if(get(key) != -1){
            LRU.get(key).value = value;
            return;
        }
        if(LRU.size() == capacity){
            LRU.remove(head.next.key); // remove the first element in the hashmap
            head.next = head.next.next;// move head to the second element
            head.next.prev = head; // prev of second ele points to head
        }
        Node curr = new Node(key, value);
        LRU.put(key, curr);
        move_to_tail(curr);
    }
    
    public void move_to_tail(Node node){
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
        node.next = tail;
    }
}