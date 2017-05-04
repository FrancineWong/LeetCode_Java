import java.util.Stack;

/*You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes 
 * first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7*/
public class Q445_Add_Two_Numbers_II {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	/*Stack to realize the FILO*/
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		while(l1!=null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		while(l2!=null) {
			s2.push(l2.val);
			l2 = l2.next;
		}
		int carry = 0;
		while(!s1.isEmpty()||!s2.isEmpty()) {
			int v1 = s1.isEmpty()?0:s1.pop();
			int v2 = s2.isEmpty()?0:s2.pop();
			ListNode node = new ListNode((v1+v2+carry)%10);
			node.next = head;
			head = node;
			carry = (v1+v2+carry)/10;
		}
		if(carry==1) {
			ListNode node = new ListNode(1);
			node.next = head;
			head = node;
		}
        return head;
    }
	/*recursive to keep the status of the last element*/
	public ListNode addTwoNumbers_0(ListNode l1, ListNode l2) {
		int n1 = getLength(l1), n2 = getLength(l2);
		ListNode head = new ListNode(1);
		head.next = (n1>n2) ?helper(l1, l2, n1-n2):helper(l2, l1, n2-n1);
		if(head.next.val>9) {
			head.next.val %= 10;
			return head;
		}
		return head.next;
	}
	private int getLength(ListNode l) {
		int cnt = 0;
		while(l!=null) {
			cnt++;
			l = l.next;
		}
		return cnt;
	}
	private ListNode helper(ListNode l1, ListNode l2, int diff) {
		if(l1==null) return null;
		ListNode res = diff==0?new ListNode(l1.val+l2.val):new ListNode(l1.val);
		ListNode pos = diff==0?helper(l1.next, l2.next, 0): helper(l1.next, l2, diff-1);
		if(pos!=null && pos.val>9) {
			pos.val %= 10;
			res.val++;
		}
		res.next = pos;
		return res;
	}
	public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
		int n1 = getLength(l1), n2 = getLength(l2);
		int diff = Math.abs(n1-n2);
		if(n1<n2) {
			ListNode tmp = l1;
			l1 = l2;
			l2 = tmp;
		}
		ListNode dummy = new ListNode(0), cur = dummy, right = cur;
		while(diff>0) {
			cur.next = new ListNode(l1.val);
			if(l1.val!=9) right = cur.next;
			cur = cur.next;
			l1 = l1.next;
			diff--;
		}
		while(l1!=null) {
			int val = l1.val+l2.val;
			if(val>9) {
				val %= 10;
				right.val++;
				while(right.next!=null) {
					right.next.val = 0;
					right = right.next;
				}
				right = cur;
			}
			cur.next = new ListNode(val);
			if(val!=9) right = cur.next;
			cur = cur.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		return (dummy.val==1)?dummy:dummy.next;
	}
}
