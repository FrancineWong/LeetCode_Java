import java.util.Arrays;

/*Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?

*/
public class Q324_Wiggle_Sort_II {
	//wrong answer
	public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        //反向插入
        
        for(int i = 0; i<=n/2; i += 2) {
        	if(i%1==0) {
        		int temp = nums[i];
        		nums[i] = nums[n - i/2];
        		nums[n-i/2] = temp;
        	}
        }
    }
	//https://discuss.leetcode.com/topic/41464/step-by-step-explanation-of-index-mapping-in-java/2
	public void wiggleSort_0(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
    private void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] =temp;
    }
    private int findKthLargest(int[] nums, int k) {
    	return 0;
    }
}
