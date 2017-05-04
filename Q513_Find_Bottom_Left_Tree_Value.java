import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q513_Find_Bottom_Left_Tree_Value {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
	public int findBottomLeftValue(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
        	int n = q.size();
        	List<Integer> l = new ArrayList<>();
        	for(int i=0; i<n; i++) {
        		TreeNode node = q.poll();
        		l.add(node.val);
        		if(node.left!=null) q.offer(node.left);
        		if(node.right!=null) q.offer(node.right);
        	}
        	list.add(l.get(0));
        }
        return list.get(list.size()-1);
    }
}
