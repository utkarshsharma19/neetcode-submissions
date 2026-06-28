class ListNode{
    ListNode next;
    ListNode prev;
    int key;
    int val;
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    int capacity;
    ListNode head;
    ListNode tail;
    HashMap<Integer, ListNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

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
    
    public int get(int key) {
        if(map.containsKey(key)) {
        remove(map.get(key));
        add(map.get(key));
            return map.get(key).val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            remove(node);
            add(node);
        } else {
            if(map.size() == capacity) {
                ListNode lru = head.next;
                remove(lru);
                map.remove(lru.key);
            }
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            add(node);
        }
    }
}
