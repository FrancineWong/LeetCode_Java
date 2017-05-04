
public class Q538_Convert_BST_to_Greater_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	int sum = 0;

	public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
	public void convert(TreeNode cur) {
		if(cur==null) return;
		convert(cur.right);
		cur.val += sum;
		sum = cur.val;
		convert(cur.left);
	}
}
