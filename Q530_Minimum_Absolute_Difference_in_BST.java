import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;
/*Given a binary search tree with non-negative values, find the minimum absolute difference between values 
 * of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.*/

public class Q530_Minimum_Absolute_Difference_in_BST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public int getMinimumDifference(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			pq.offer(cur.val);
			if (cur.left != null) queue.offer(cur.left);
			if (cur.right != null) queue.offer(cur.right);
		}
		int pre = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			min = Math.min(min, (int)Math.abs(cur-pre));
			pre = cur;
		}
		return min;
	}
	
	int min = Integer.MAX_VALUE;
    Integer prev = null;
    
    public int getMinimumDifference_0(TreeNode root) {
        if (root == null) return min;
        
        getMinimumDifference(root.left);
        
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        
        getMinimumDifference(root.right);
        
        return min;
    }
    //What if it is not a BST? (Follow up of the problem) The idea is to put values in a TreeSet and then every 
    //time we can use O(lgN) time to lookup for the nearest values.

   //Solution 2 - Pre-Order traverse, time complexity O(NlgN), space complexity O(N).

 
    TreeSet<Integer> set = new TreeSet<>();
    int min1 = Integer.MAX_VALUE;
    
    public int getMinimumDifference_1(TreeNode root) {
        if (root == null) return min1;
        
        if (!set.isEmpty()) {
            if (set.floor(root.val) != null) {
                min1 = Math.min(min1, root.val - set.floor(root.val));
            }
            if (set.ceiling(root.val) != null) {
                min1 = Math.min(min1, set.ceiling(root.val) - root.val);
            }
        }
        
        set.add(root.val);
        
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);
        
        return min;
    }
    		
}
