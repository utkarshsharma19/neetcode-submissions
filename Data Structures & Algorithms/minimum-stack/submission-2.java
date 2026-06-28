class Pair {
    int min;
    int val;
    public Pair(int min, int val) {
        this.min = min;
        this.val = val;
    }
}
class MinStack {
    Stack<Pair> stk;
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        if(stk.isEmpty()) {
            stk.push(new Pair(val, val));
        } else {
            int currentMin = stk.peek().min;
            stk.push(new  Pair(Math.min(currentMin, val), val));
        }
    }
    
    public void pop() {
        if(stk.isEmpty()) {
            throw new EmptyStackException();
        } else {
            stk.pop();
        }
    }
    
    public int top() {
        return stk.peek().val;
    }
    
    public int getMin() {
       return  stk.peek().min;
    }
}
