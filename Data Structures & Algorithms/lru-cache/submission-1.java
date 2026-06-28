class Node {
    Node next;
    Node prev;
    int val;
    int key;
    public Node(int key,int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    private void add(Node node) {
        Node prevEnd = tail.prev;
        prevEnd.next = node;
        node.next = tail;
        tail.prev = node;
        node.prev = prevEnd;

    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        else {
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            add(node);
        } else {
            if(map.size() == capacity) {
                Node lru = head.next;
                remove(lru);
                map.remove(lru.key);
            }
            Node node = new Node(key, value);
            add(node);
            map.put(key, node);
        }
    }
}
