/*Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer 
should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has 
two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/
public class Q116_Populating_Next_Right_Pointers_in_Each_Node {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	public void connect(TreeLinkNode root) {
		if (root == null) return;
	    TreeLinkNode pre = root;
	    TreeLinkNode cur = null;
	    while(pre.left!=null) {
	        cur = pre;
	        while(cur!=null) { //layer travesal
	            cur.left.next = cur.right;
	            if(cur.next!=null) cur.right.next = cur.next.left;
	            cur = cur.next; //move to the right sub tree;
	        }
	        pre = pre.left;
	    }
    }
	/***************************************************************************************/
	public void connect_0(TreeLinkNode root) {
	      if(root == null) return;    
	      helper(root.left, root.right);    
	    }
	    
    void helper(TreeLinkNode node1, TreeLinkNode node2){
      if(node1 == null) return;    
      node1.next = node2;
      helper(node1.left, node1.right);
      helper(node2.left, node2.right);
      helper(node1.right, node2.left);
    }
	/****************************************************************************************/
    public void connect_1(TreeLinkNode root) {
        TreeLinkNode level_start=root;
        while(level_start!=null){
            TreeLinkNode cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;
                
                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }
}
