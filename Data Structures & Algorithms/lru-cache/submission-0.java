class ListNode{
    int key;
    int value;
    ListNode next;
    ListNode prev;
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
class LRUCache {
    int capacity;
    ListNode head;
    ListNode tail;
    HashMap<Integer, ListNode> map;
    private void add(ListNode node) {
        ListNode prevEnd = tail.prev;
        prevEnd.next = node;
        node.next = tail;
        node.prev = prevEnd;
        tail.prev = node;
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            ListNode node  = map.get(key);
            node.value = value;
            remove(node);
            add(node);

        } else {
            if (map.size() == capacity) {
                ListNode lru = head.next;
                remove(lru);
                map.remove(lru.key);
            }
            ListNode node = new ListNode(key, value);
            add(node);
            map.put(key, node);
        }
    }
}
