import java.util.Stack;

/*Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.*/
public class Q105_Construct_Binary_Tree_from_Preorder_and_Inorder {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	/**Say we have 2 arrays, PRE and IN. Preorder traversing implies that PRE[0] is the root node.
	 * Then we can find this PRE[0] in IN, say it's IN[5].
	 * Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is 
	 * on the right side.
	 * Recursively doing this on subarrays, we can build a tree out of it*/
	/*仍然以上面那棵二叉树为例，我们可以发现，对于后序遍历来说，最后一个元素一定是根节点，也就是1。然后我们在中序遍历的结果里面找到1所在的位置，
	 * 那么它的左半部分就是其左子树，有半部分就是其右子树。
	 * 我们将中序遍历左半部分425取出，同时发现后序遍历的结果也在相应的位置上面，只是顺序稍微不一样，也就是452。我们可以发现，后序遍历中的2就
	 * 是该子树的根节点。
	 * 上面说到了左子树，对于右子树，我们取出637，同时发现后序遍历中对应的数据偏移了一格，并且顺序也不一样，为673。而3就是这颗右子树的根节点。
	 * 重复上述过程，通过后续遍历找到根节点，然后在中序遍历数据中根据根节点拆分成两个部分，同时将对应的后序遍历的数据也拆分成两个部分，重复递归，就可以得到整个二叉树了。

*/
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
	public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
	    if (preStart > preorder.length - 1 || inStart > inEnd) {
	        return null;
	    }
	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inIndex = 0; // Index of current root in inorder
	    for (int i = inStart; i <= inEnd; i++) {
	        if (inorder[i] == root.val) {
	            inIndex = i;
	        }
	    }
	    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
	    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
	    return root;
	}
	/* Iterator
	 * Keep pushing the nodes from the preorder into a stack (and keep making the tree by adding nodes to the left of 
	 * the previous node) until the top of the stack matches the inorder.
	 * 
	 * At this point, pop the top of the stack until the top does not equal inorder (keep a flag to note that you 
	 * have made a pop).
	 * 
	 * Repeat 1 and 2 until preorder is empty. The key point is that whenever the flag is set, insert a node to the 
	 * right and reset the flag.*/
	public TreeNode buildTree_0(int[] preorder, int[] inorder) {
	        if(preorder.length==0)
	            return null;
	        
	        Stack<Integer> s = new Stack<Integer>();
	        Stack<TreeNode> st = new Stack<TreeNode>();
	        TreeNode t,root;
	        int i,j,f;
	        
	        f=i=j=0;
	        s.push(preorder[i]);
	        
	        root = new TreeNode(preorder[i]);
	        st.push(root);
	        t = root;
	        i++;
	        
	        while(i<preorder.length)
	        {
	            if(!st.empty() && st.pop().val==inorder[j])
	            {
	                t = st.pop();
	                st.pop();
	                s.pop();
	                f = 1;
	                j++;
	            }
	            else
	            {
	                if(f==0)
	                {
	                    s.push(preorder[i]);
	                    t.left = new TreeNode(preorder[i]);
	                    t = t.left;
	                    st.push(t);
	                    i++;
	                }
	                else 
	                {
	                    f = 0;
	                    s.push(preorder[i]);
	                    t.right = new TreeNode(preorder[i]);
	                    t = t.right;
	                    st.push(t);
	                    i++;
	                }
	            }
	        }
	        
	        return root;
	    }
}
