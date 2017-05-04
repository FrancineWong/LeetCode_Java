import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is 
 * defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). 
 * So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest 
 * frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.*/
public class QMostFrequentSubTreeSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
        if(root==null) return null;
        else sumMap(root, sums);
        Integer max = Integer.MIN_VALUE;
        for(int i: sums.values()) {
        	if(i>max) max = i;
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int key: sums.keySet()) {
        	if(sums.get(key)==max) res.add(key);
        }
        int[] finalRes = new int[res.size()];
        
        int index=0;
        for( int i:res) {
        	finalRes[index++] = i;
        }
        return finalRes;
    }
	public int sum(TreeNode root) {
		if(root==null) return 0;
		else {
			return root.val + sum(root.left) + sum(root.right);
		}
	}
	public void sumMap(TreeNode root, Map<Integer, Integer> map) {
		if(root==null) return;
		else {
			map.put(sum(root), map.getOrDefault(sum(root), 0)+1);
			sumMap(root.left, map);
			sumMap(root.right, map);
		}
	}
}
