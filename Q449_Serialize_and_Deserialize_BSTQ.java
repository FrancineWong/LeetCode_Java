import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q449_Serialize_and_Deserialize_BSTQ {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private static final String SEP = ",";
	private static final String NULL = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        if(root==null) return NULL;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.empty()) {
        	root = st.pop();
        	sb.append(root.val).append(SEP);
        	if(root.right!=null) st.push(root.right);
        	if(root.left!=null) st.push(root.left);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(!data.equals(NULL)) return null;
        String[] strs = data.split(SEP);
        Queue<Integer> q = new LinkedList<>();
        for(String e:strs) q.offer(Integer.parseInt(e));
        return getNode(q);
    }
    
    private TreeNode getNode(Queue<Integer> q) {
    	if(q.isEmpty()) return null;
    	TreeNode root = new TreeNode(q.poll());
    	Queue<Integer> smallerQueue = new LinkedList<>();
    	while(!q.isEmpty()&&q.peek()<root.val) smallerQueue.offer(q.poll());
    	root.left = getNode(smallerQueue);
    	root.right =  getNode(q);
    	return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
