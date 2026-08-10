class Node {
    Node next;
    Node prev;
    int key;
    int value;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    private void add(Node head) {
        Node prevEnd = tail.prev;
        prevEnd.next = head;
        head.next = tail;
        head.prev = prevEnd;
        tail.prev = head;
    }

    private void remove(Node head) {
        head.prev.next = head.next;
        head.next.prev = head.prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            remove(map.get(key));
            add(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            add(node);
        } else {
            if(map.size() == capacity) {
                Node lru = head.next;
                remove(lru);
                map.remove(lru.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            add(node);
        }
    }
}
