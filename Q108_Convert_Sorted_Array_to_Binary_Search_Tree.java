
/*Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

*/
public class Q108_Convert_Sorted_Array_to_Binary_Search_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length-1);
    }
    public TreeNode createBST(int[] nums, int start, int end){
		if(start>end) return null;
	    int mid = (start+end)/2;
	    TreeNode root = new TreeNode(nums[mid]);
		root.left = createBST(nums, start, mid-1);
		root.right = createBST(nums, mid+1, end);
		return root;
	}
}
