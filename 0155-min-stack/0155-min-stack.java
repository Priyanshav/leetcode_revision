class MinStack {
    // private Stack<int[]> st;
    private Stack<Long> st;
    private long mini;
    public MinStack() {
        st = new Stack<>();
        mini = Integer.MAX_VALUE;
    }
    
    public void push(long value) {
        // if(st.isEmpty()){
        //     st.push(new int[]{value, value});
        //     return;
        // }
        // int mini = Math.min(getMin(), value);
        // st.push(new int[]{value, mini});
        if(st.isEmpty()){
            st.push(value);
            mini = value;
        } else{
            if(value > mini) st.push(value);
            else{
                st.push(2L*value - mini);
                mini = value;
            }
        }
    }
    
    public void pop() {
        // st.pop();
        if(st.isEmpty()) return;
        long x = st.pop();
        if(x < mini) mini = 2L*mini - x;
    }
    
    public long top() {
        // return st.peek()[0];
        if(st.isEmpty()) return -1;
        long x = st.peek();
        if(x > mini) return x;
        else return mini;
    }
    
    public long getMin() {
        // return st.peek()[1];
        return mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */