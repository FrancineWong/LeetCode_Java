
public class Q104_Maximum_Depth_of_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int maxDepth(TreeNode root) {
		if(root==null) return 0;
        int dep_left = maxDepth(root.left)+1;
        int dep_right = maxDepth(root.right)+1;
        return dep_left>dep_right?dep_left:dep_right;
    }
	
}
