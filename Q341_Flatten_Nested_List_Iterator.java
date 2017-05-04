import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

*/

public class Q341_Flatten_Nested_List_Iterator implements Iterator<Integer> {
	Queue<Integer> queue = new LinkedList<Integer>();
    public Q341_Flatten_Nested_List_Iterator(List<NestedInteger> nestedList) {
        createQueue(nestedList);
    }
    
    public void createQueue(List<NestedInteger> nestedList) {
    	if(nestedList==null) return;
    	for(int i=0; i<nestedList.size(); i++) {
    		if(nestedList.get(i).isInteger()) queue.offer(nestedList.get(i).getInteger());
    		else createQueue(((NestedInteger) nestedList).getList());
    	}
    }

    @Override
    public Integer next() {
        queue.poll();
        return queue.peek();
    }

    @Override
    public boolean hasNext() {
        return queue.isEmpty();
    }
    /************************************************************************/
    Stack<NestedInteger> stack = new Stack<>();
    public Q341_Flatten_Nested_List_Iterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    public Integer next_0() {
        return stack.pop().getInteger();
    }

    public boolean hasNext_0() {
        while(!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if(curr.isInteger()) {
                return true;
            }
            stack.pop();
            for(int i = curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
    /*******  Iterator  **/
    public NestedIterator(List<NestedInteger> nestedList) {
        lists = new Stack<>();
        lists.push(nestedList.listIterator());
    }

    public Integer next() {
        hasNext();
        return lists.peek().next().getInteger();
    }

    public boolean hasNext() {
        while (!lists.empty()) {
            if (!lists.peek().hasNext()) {
                lists.pop();
            } else {
                NestedInteger x = lists.peek().next();
                if (x.isInteger())
                    return lists.peek().previous() == x;
                lists.push(x.getList().listIterator());
            }
        }
        return false;
    }
    
    private Stack<ListIterator<NestedInteger>> lists;
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */