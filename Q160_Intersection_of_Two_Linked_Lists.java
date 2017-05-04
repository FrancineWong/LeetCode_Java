/*If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.*/
public class Q160_Intersection_of_Two_Linked_Lists {
	
	public class ListNode {
			int val;
			ListNode next;
			ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        //get tail and size
        Result result1 = getTailAndSize(headA);
        Result result2 = getTailAndSize(headB);
        
        //if different tail nodes, then there's no intersection
        if(result1.tail!=result2.tail) return null;
        
        //set pointers to the start of each link list 
        ListNode shorter = result1.size<result2.size?headA:headB;
        ListNode longer = result1.size<result2.size?headB:headA;
        
        //advance the pointer for the longer list by difference in lengths
        longer = getKthNode(longer, Math.abs(result1.size-result2.size));
        
        //move pointers until you jave a collision
        while(shorter!=longer) {
        	shorter = shorter.next;
        	longer = longer.next;
        }
        
        return longer;
    }
	
	class Result {
		public ListNode tail;
		public int size;
		public Result(ListNode tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}
	
	Result getTailAndSize(ListNode list) {
		if(list == null) return null;
		
		int size = 1;
		ListNode current = list;
		while(current.next!=null) {
			size++;
			current = current.next;
		}
		return new Result(current, size);
	}
	
	ListNode getKthNode(ListNode head, int k){
		ListNode current = head;
		while(k>0&&current!=null) {
			current = current.next;
			k--;
		}
		return current;
	}
 	
}
