/*Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter 
what you leave beyond the new length.*/
public class Q080_Remove_Duplicates_from_Sorted_Array_II {
	public int removeDuplicates(int[] nums) {
		int len = nums.length;
        if(len<3) return len;
		int index = 0;
		for(int i=0; i<len-2; i++) {
			if(nums[i]==nums[i+1]&&nums[i]==nums[i+2]) continue;
			else nums[index++] = nums[i];
		}
		nums[index++] = nums[len-2];
		nums[index++] = nums[len-1];
		System.out.println(index);
        return index;
    }
}
