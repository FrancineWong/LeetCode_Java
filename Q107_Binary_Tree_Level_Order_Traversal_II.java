
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to 
 * right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]*/
public class Q107_Binary_Tree_Level_Order_Traversal_II {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	//BFS
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root); // add element at the head of the queue
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val); //poll: remove
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }
	//DFS
	/*I believe you're concerned about the arrangement of lists of node's value. add(index, E), in which the index 
	 * is zero, will insert the incoming List at the top of the wrapper List. SInce the nature of linkedlist, a new 
	 * node will be created and points to the current head, meaning no shift of rest lists is necessary.

	Additionally, in DFS solution, "list.get(list.size()-level-1).add(root.val);" will retrieve the list of 
	corresponding level and add its value, when it's been visited.*/
	public List<List<Integer>> levelOrderBottom_0(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }
    
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>()); //
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }
	
}
