import java.util.ArrayList;
import java.util.List;

/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level 
 * by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]*/
public class Q102_Binary_Tree_Level_Order_TraversalQ {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<List<Integer>>();
        createLevelList(root, levelList, 0);
        return levelList;
    }
	
	public void createLevelList(TreeNode root, List<List<Integer>> levelList, int level) {
		if(root==null) return;
		List<Integer> list = null;
		if(levelList.size()==level) {
			list = new ArrayList<Integer>();
			levelList.add(list);
		}else {
			list = levelList.get(level);
		}
		list.add(root.val);
		createLevelList(root.left, levelList, level+1);
		createLevelList(root.right, levelList, level+1);
	}
}
