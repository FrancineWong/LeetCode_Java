import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.*/

public class Q155_Min_Stack extends Stack<Integer> {
	
	//keep track of the minimum
	
	/** initialize your data structure here. */
	int min = Integer.MAX_VALUE;
	Stack<Integer> myStack;
	Stack<Integer> track;
    public Q155_Min_Stack() {
        myStack = new Stack<Integer>();
        track = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(x<=min) track.push(x);
        myStack.push(x);
    }
    
    public void pop() {
    	int value =  myStack.pop();
        if(value==min) {
        	track.pop();//update the the minimum number
        }
    }
    
    public int top() {
        return myStack.peek();
    }
    
    public int getMin() {
    	if(myStack.isEmpty()) return Integer.MAX_VALUE;
    	else return min;
    }
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
