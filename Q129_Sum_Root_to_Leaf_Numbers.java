

/*Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.*/
public class Q129_Sum_Root_to_Leaf_Numbers {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
	public int sumNumbers(TreeNode root, int sum) {
		if(root == null) return 0;
		else if(root.left==null&&root.right==null) {
			return sum*10 + root.val;
		}else {
			return sumNumbers(root.left, sum*10 + root.val) + sumNumbers(root.right, sum*10 + root.val);
		}
	}
}
