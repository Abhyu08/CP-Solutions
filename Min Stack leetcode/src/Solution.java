import java.util.Stack;

class MinStack {

    Stack<Long> stk = new Stack<>();
    Stack<Long> min = new Stack<>();
    long min_val;

    public MinStack() {
        min_val = 1000000000;
    }

    public void push(long val) {

        if(stk.empty()==true){
            min_val = val;
            stk.push(val);
            min.push(val);
        }else if(min.peek() > val){
            min_val = val;
            stk.push(val);
            min.push(min_val);
        }else{
            stk.push(val);
            min.push(min.peek());
        }

    }

    public void pop() {
        stk.pop();
        min.pop();

    }

    public long top() {
        return  stk.peek();
    }

    public long getMin() {
        return min.peek();
    }
    
    
    /*
     ArrayList<Long> stk = new ArrayList<>();
        int index;
        long min_val = 10000000;
     ArrayList<Long> min = new ArrayList<>();
    public MinStack() {
        index = -1;
        min_val =10000000;
    }
    
    public void push(int val) {
           long v = val;
           stk.add(v);
           if(min.size() < 1){
                min.add(v);
               min_val = v;
           }  
            else if(min_val > val ){
                v = val;
                stk.add(v);
                min.add(v);
                min_val = v;
            }else{
                min.add(min_val);
            }
           index++;
    }
    
    public void pop() {
        stk.remove(index);
        index--;
    }
    
    public int top() {
         return stk.get((int)(index));
    }
    
    public int getMin() {
         return min.get((int)(index));
    }
    */
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */