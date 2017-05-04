import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
 *  you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

*/
public class Q199_Binary_Tree_Right_Side_View {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	//level travesal, last element of each level
	List<Integer> list = new ArrayList<Integer>();
	public List<Integer> rightSideView(TreeNode root) {
		if(root==null) return null;
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int levelLen = queue.size();
			List<Integer> level = new ArrayList<Integer>();
			for( int i = 0; i<levelLen; i++) {
				if(queue.peek().left!=null) queue.offer(queue.peek().left);
				if(queue.peek().right!=null) queue.offer(queue.peek().right);
				level.add(queue.poll().val);
			}
			lists.add(level);
		}
		for( int i = 0; i<lists.size(); i++) {
			list.add(lists.get(i).get(lists.get(i).size()-1));
		}
        return list;
    }
	/*********************************************************************************/
	public List<Integer> rightSideView_0(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}
