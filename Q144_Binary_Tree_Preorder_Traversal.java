
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

*/
public class Q144_Binary_Tree_Preorder_Traversal {
	//tag: stack
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> rights = new Stack<TreeNode>();
		while(root != null) {
			list.add(root.val);
			if (root.right != null) {
				rights.push(root.right);
			}
			root = root.left;
			if (root == null && !rights.isEmpty()) {
				root = rights.pop();
			}
		}
	    return list;
    }
}
