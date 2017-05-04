
import java.util.Stack;

/*Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

*/
public class Q173_Binary_Search_Tree_Iterator {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
//memory limit error
//	private Queue<Integer> queue = new LinkedList<Integer>();
//	public Q173_Binary_Search_Tree_Iterator(TreeNode root) {
//        createQue(root);
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return queue.isEmpty();
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        return queue.poll();
//    }
//    
//    public void createQue(TreeNode root) {
//    	while(root!=null) {
//    		createQue(root.left);
//    		queue.offer(root.val);
//    		createQue(root.right);
//    	}
//    }
    /**
     * Your BSTIterator will be called like this:
     * BSTIterator i = new BSTIterator(root);
     * while (i.hasNext()) v[f()] = i.next();
     */
    /*****************************************************************************/
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public Q173_Binary_Search_Tree_Iterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }
}
