/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.*/
public class Q081_Search_in_Rotated_Sorted_Array_II {
	public boolean search(int[] nums, int target) {
		int len = nums.length;
		int piv = 0;
		for( int i=0; i<len-1; i++) {
			if(nums[i]>nums[i+1]) piv = i+1;
		}
		int lo = 0;
		int hi = len-1;
		while(lo<hi) {
			int mid = (lo+hi)/2;
			int realmid=(mid+piv)%len;
            if(nums[realmid]==target) return true;
            if(nums[realmid]<target)lo=mid+1;
            else hi=mid-1;
		}
        return false;
    }
	/***************************************************************************************/
	// 这个问题在面试中不会让实现完整程序
    // 只需要举出能够最坏情况的数据是 [1,1,1,1... 1] 里有一个0即可。
    // 在这种情况下是无法使用二分法的，复杂度是O(n)
    // 因此写个for循环最坏也是O(n)，那就写个for循环就好了
    //  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
    //  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
    public boolean search_0(int[] A, int target) {
        for (int i = 0; i < A.length; i ++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }
    /************************************************************************************/
    boolean search(int A[], int n, int target) {
        int start = 0, end = n-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(A[mid]==target) return true;  
       
            if(A[mid]<A[end]) { // right half sorted
                if(target>A[mid] && target<=A[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
            else if(A[mid]>A[end]) {  // left half sorted
                if(target>=A[start] && target<A[mid]) 
                    end = mid-1;
                else
                    start = mid+1;
            }
            else {
                end--;
            }
        }
        return false;
    }    
}
