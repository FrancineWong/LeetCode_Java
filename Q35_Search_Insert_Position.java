/*Given a sorted array and a target value, return the index if the target is found. If not, return the index where 
 * it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0*/
public class Q35_Search_Insert_Position {
	public int searchInsert(int[] nums, int target) {
		int l = 0, h = nums.length - 1;
		while(l<h) {
			int middle = (l+h)/2;
			if(nums[middle]==target) return middle;
			else if(nums[middle]<target) l = middle + 1;
			else h = middle;
		}
		if(target>nums[h]) return h+1;
		else return l;
    }
}
