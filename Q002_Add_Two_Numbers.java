/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored 
 * in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a 
 * linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8*/
public class Q002_Add_Two_Numbers {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        int carry = 0;
        if(l1==null&&l2==null) return null;
        while(l1!=null||l2!=null) {
        	int value = 0;
        	if(l1!=null) {
        		value += l1.val;
        		l1 = l1.next;
        	}
        	if(l2!=null) {
        		value += l2.val;
        		l2 = l2.next;
        	}
        	temp = new ListNode((value+carry)%10);
        	temp = temp.next;
        	carry = (value+carry)/10;
        }
        if(carry == 1) temp = new ListNode(1);
        return res;
    }
}
