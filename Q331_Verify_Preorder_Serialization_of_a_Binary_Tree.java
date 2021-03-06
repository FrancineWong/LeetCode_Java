import java.util.Stack;

public class Q331_Verify_Preorder_Serialization_of_a_Binary_Tree {
	/*Some used stack. Some used the depth of a stack. Here I use a different perspective. In a binary tree, 
	 * if we consider null as leaves, then all non-null node provides 2 outdegree and 1 indegree (2 children 
	 * and 1 parent), except root all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
	 * Suppose we try to build this tree. During building, we record the difference between out degree and in 
	 * degree diff = outdegree - indegree. When the next node comes, we then decrease diff by 1, because the node 
	 * provides an in degree. If the node is not null, we increase diff by 2, because it provides two out degrees.
	 *  If a serialization is correct, diff should never be negative and diff will be zero when finished.*/
	
	public boolean isValidSerialization(String preorder) {
		String[] nodes = preorder.split(",");
	    int diff = 1;
	    for (String node: nodes) {
	        if (--diff < 0) return false;
	        if (!node.equals("#")) diff += 2;
	    }
	    return diff == 0; //indegree , 引入次数
    }
	/***************************************************************/
	public boolean isValidSerialization_0(String preorder) {
        // using a stack, scan left to right
        // case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #
        if (preorder == null) {
            return false;
        }
        Stack<String> st = new Stack<>();
        String[] strs = preorder.split(",");
        for (int pos = 0; pos < strs.length; pos++) {
            String curr = strs[pos];
            while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
                st.pop();
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
            st.push(curr);
        }
        return st.size() == 1 && st.peek().equals("#");
    }
}
