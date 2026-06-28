class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null); // so map.get(null) returns null

        Node cur = head;
        while (cur != null) {
            // ensure copy node exists
            oldToCopy.putIfAbsent(cur, new Node(cur.val));

            // ensure copies for next/random exist
            if (!oldToCopy.containsKey(cur.next)) {
                oldToCopy.put(cur.next, cur.next == null ? null : new Node(cur.next.val));
            }
            if (!oldToCopy.containsKey(cur.random)) {
                oldToCopy.put(cur.random, cur.random == null ? null : new Node(cur.random.val));
            }

            // wire pointers on the copy
            Node copy = oldToCopy.get(cur);
            copy.next   = oldToCopy.get(cur.next);
            copy.random = oldToCopy.get(cur.random);

            cur = cur.next;
        }
        return oldToCopy.get(head);
    }
}
