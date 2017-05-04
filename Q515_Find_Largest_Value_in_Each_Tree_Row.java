import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.Queue;

public class Q515_Find_Largest_Value_in_Each_Tree_Row {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public List<Integer> largestValues(TreeNode root) {
        if(root==null) return null;
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
        	int n = queue.size(), mx = Integer.MIN_VALUE;
        	for(int i=0; i<n; i++) {
        		TreeNode node = queue.poll();
        		mx = Math.max(mx, node.val);
        		if(node.left!=null) queue.offer(node.left);
        		if(node.right!=null) queue.offer(node.right);
        	}
        	res.add(mx);
        }
        return res;
    }
	
	public List<Integer> largestValues_0(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res, 0);
		return res;
	}
	private void helper(TreeNode root, List<Integer> res,  int d) {
		if(root==null) return ;
		//expand list size
		if(d==res.size()) res.add(root.val);
		else res.set(d,  Math.max(res.get(d), root.val));
		helper(root.left, res, d+1);
		helper(root.right, res, d+1);
	}
}
