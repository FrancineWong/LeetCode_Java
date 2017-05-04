

public class invertTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}
	
	public TreeNode invertTreeNode(TreeNode root){
		if(root==null) return null;
		TreeNode temp = root.left;
		root.left = invertTreeNode(root.right);
		root.right = invertTreeNode(temp);
		return root;
	}

}
