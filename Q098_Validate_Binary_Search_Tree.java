
public class Q098_Validate_Binary_Search_Tree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean isValidBST(TreeNode root) {
        return Q098_Validate_Binary_Search_Tree.checkBST(root, null, null);
    } 
	
	private static boolean checkBST(TreeNode root, Integer min, Integer max) {
		if(root==null) return true;
		if((min!=null&&root.val<=min)||(max!=null&&root.val>=max)) return false;
		return checkBST(root.left, min, root.val)&&checkBST(root.right, root.val, max);
	}
}
