/*Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v 
and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant 
of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2,
 since a node can be a descendant of itself according to the LCA definition.

*/
public class Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(!covers(root, p)||!covers(root, q)) return null;
        return helper(root, p, q);
    }
	
	public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null||root==p||root==q) return root;
		
		boolean pIsOnLeft = covers(root.left, p);
		boolean qIsOnLeft = covers(root.left, q);
		if(pIsOnLeft!=qIsOnLeft) return root;
		
		TreeNode childSide = pIsOnLeft?root.left:root.right;
		return helper(childSide, p, q);
	}
	
	public boolean covers(TreeNode root, TreeNode p) {
		if(root == null) return false;
		if(root == p) return true;
		return covers(root.left, p)||covers(root.right, p);
	}
	
}
