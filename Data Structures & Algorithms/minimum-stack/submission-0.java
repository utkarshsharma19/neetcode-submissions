

class Node {
    int val;
    int min;  
    public Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

class MinStack {
    private final Stack<Node> stack = new Stack<>();

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Node(val, val));
        } else {
            int currentMin = stack.peek().min;
            stack.push(new Node(val, Math.min(val, currentMin)));
        }
    }

    public void pop() {
        if (stack.isEmpty()) throw new EmptyStackException();
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) throw new EmptyStackException();
        return stack.peek().val;
    }

    public int getMin() {
        if (stack.isEmpty()) throw new EmptyStackException();
        return stack.peek().min;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
