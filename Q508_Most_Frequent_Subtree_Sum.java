import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q508_Most_Frequent_Subtree_Sum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
        if(root==null) return new int[0];
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
