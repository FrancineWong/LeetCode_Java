/*Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.*/
public class Q109_Convert_Sorted_List_to_Binary_Search_Tree {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private ListNode next;
	public TreeNode sortedListToBST(ListNode head) {
		next = head;
	    int height=0;
	    while(next!=null) {
	        height++;
	        next = next.next;
	    }
	    next = head;
	    return recur(height);
    }
	private TreeNode recur(int n){
	    if(n==0) return null;
	    if(n==1){
	        TreeNode x = new TreeNode(next.val);
	        next = next.next;
	        return x;
	    }
	    TreeNode temp = new TreeNode(0);
	    temp.left = recur(n/2);
	    temp.val=next.val;
	    next=next.next;
	    temp.right=recur((n-1)/2);
	    return temp;
	}
	/**************************************************************************************/
	public TreeNode sortedListToBST_0(ListNode head) {
	    if(head==null) return null;
	    return toBST(head,null);
	}
	public TreeNode toBST(ListNode head, ListNode tail){
	    ListNode slow = head;
	    ListNode fast = head;
	    if(head==tail) return null;
	    
	    while(fast!=tail&&fast.next!=tail){
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    TreeNode thead = new TreeNode(slow.val);
	    thead.left = toBST(head,slow);
	    thead.right = toBST(slow.next,tail);
	    return thead;
	}
	/**************************************************************************************/
	
}
