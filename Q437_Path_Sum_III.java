/*
 * You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from 
parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11*/
public class Q437_Path_Sum_III {
	public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
	}

	public int pathSum(TreeNode root, int sum) {
		if(root==null) return 0;
		int pathRoot = findPath(root, sum, 0);
		int pathLeft = pathSum(root.left, sum);
		int pathRight = pathSum(root.right, sum);
		return pathRoot+pathLeft+pathRight;
    }
	
	public int findPath(TreeNode root, int sum, int currentSum) {
		if(root==null) return 0;
		currentSum += root.val;
		int path = 0;
		if(currentSum == sum) path++;
		path += findPath(root.left, sum, currentSum);
		path += findPath(root.right, sum, currentSum);
		return path;
	}
	
}
