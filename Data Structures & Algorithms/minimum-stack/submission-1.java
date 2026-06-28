class Node {
    int val;
    int min;  
    public Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
}
class MinStack {
    Stack<Node> stk = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(stk.isEmpty()) {
            stk.push(new Node(val, val));
        } else {
            int currentMin = stk.peek().min;
            stk.push(new Node(val, Math.min(val, currentMin)));
        }
    }
    
    public void pop() {
        if(stk.isEmpty()) {
            throw new EmptyStackException();
        }
        stk.pop();
    }
    
    public int top() {
        return stk.peek().val;
    }
    
    public int getMin() {
        return stk.peek().min;
    }
}
