import java.util.HashMap;
import java.util.Map;

public class Q337_House_Robber_III {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	//@DFS, TREE
	//time limit error
	public int rob(TreeNode root) {
        if (root==null) return 0;
        int val = 0;
        if (root.left!=null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right!=null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
	//HashMap saving, call exsiting result
	public int rob_0(TreeNode root) {
        Map<TreeNode, Integer> m = new HashMap<>();
        return dfs(root, m);
	}
	public int dfs(TreeNode root, Map<TreeNode, Integer> m) {
        if (root==null) return 0;
        if (m.containsKey(root)) return m.get(root);
        int val = 0;
        if (root.left!=null) {
            val += dfs(root.left.left, m) + dfs(root.left.right, m);
        }
        if (root.right!=null) {
            val += dfs(root.right.left, m) + dfs(root.right.right, m);
        }
        val = Math.max(val + root.val, dfs(root.left, m) + dfs(root.right, m));
        m.replace(root, val);
        return val;
    }
	/***********************************************************************/
/*下面再来看一种方法，这种方法的递归函数返回一个大小为2的一维数组res，其中res[0]表示不包含当前节点值的最大值，res[1]表示包含当前值的最大值，
 * 那么我们在遍历某个节点时，首先对其左右子节点调用递归函数，分别得到包含与不包含左子节点值的最大值，和包含于不包含右子节点值的最大值，
 * 那么当前节点的res[0]就是左子节点两种情况的较大值加上右子节点两种情况的较大值，res[1]就是不包含左子节点值的最大值加上不包含右子节点值的
 * 最大值，和当前节点值之和，返回即可，参见代码如下：*/
	public int rob_1(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    public int[] dfs(TreeNode root) {
        if (root==null) return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}
