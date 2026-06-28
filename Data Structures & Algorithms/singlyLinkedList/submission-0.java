class ListNode{
    int val;
    ListNode next;

     public ListNode(int val) {
        this.val = val;
        this.next = null;
    }


    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class LinkedList {
    ListNode head;
    ListNode tail;

    public LinkedList() {
        this.head = new ListNode(-1);
        this.tail = this.head;

    }

    public int get(int index) {
            ListNode curr = head.next;
            int i = 0;
            while(curr!=null) {
                if(i == index) {
                    return curr.val;
                }
                i++;
                curr = curr.next;
            }
            return -1;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        if(newNode.next==null) {
            tail = newNode;
        }

    }

    public void insertTail(int val) {
        this.tail.next = new ListNode(val);
        this.tail = this.tail.next;
    }

    public boolean remove(int index) {
        ListNode curr = head;
        int i = 0;
        while(i < index && curr!=null) {
            curr = curr.next;
            i++;
        }

        if(curr!=null && curr.next !=null) {
            if(curr.next == this.tail) {
                this.tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode curr = this.head.next;
        while(curr!=null) {
            res.add(curr.val);
            curr = curr.next;
        }
        return res;
    }
}
