import java.util.ArrayList;
import java.util.List;

public class Q111_Minimum_Depth_of_Binary_Tree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int minDepth(TreeNode root) {
		if(root==null) return 0;
        int dep_left = minDepth(root.left)+1;
        int dep_right = minDepth(root.right)+1;
        if(dep_left==1) return dep_right;
        else if(dep_right==1) return dep_left;
        else return dep_left>dep_right?dep_right:dep_left;
    }
}
