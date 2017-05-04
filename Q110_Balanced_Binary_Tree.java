
public class Q110_Balanced_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	int getHeight(TreeNode root) {
		if(root == null) return -1;//base case
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	
	public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if(Math.abs(heightDiff)>1) return false;
        else return isBalanced(root.left)&&isBalanced(root.right);
	}
	
}
