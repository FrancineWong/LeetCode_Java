//Could you do it in-place with O(1) extra space?
public class Q189_Rotate_Array {
	/*****************************************************/
	public void rotate(int[] nums, int k) {
		int[] temp = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
        	temp[i] = nums[i];
        }
        for(int i=0; i<nums.length; i++) {
        	nums[(i+k)%nums.length] = temp[i];
        }
    }
	/*****************************************************/
	public void rotate_0(int[] nums, int k) {
		for(int i=0; i<k; i++) {
			int temp = nums[nums.length-1];
			for(int j=nums.length-1; j>0; j--) {
				nums[j] = nums[j-1];
			}
			nums[0] = temp;
		}
	}
	/*****************************************************/
	public void rotate_1(int[] nums, int k) {
		k %= nums.length;
	    reverse(nums, 0, nums.length - 1);
	    reverse(nums, 0, k - 1);
	    reverse(nums, k, nums.length - 1);
	}
	public void reverse(int[] nums, int start, int end) {
	    while (start < end) {
	        int temp = nums[start];
	        nums[start] = nums[end];
	        nums[end] = temp;
	        start++;
	        end--;
	    }
	}
	/*****************************************************/
	public void rotate_2(int[] nums, int k) {
		if(nums.length==0) return;
        k %= nums.length;
        // well, it depends on left rotate or right rotate
        // in this case, its right rotate so need to do a simple math
        k = nums.length-k;  
        int temp;
        // reflect [0,k-1], [k,size()-1]
        // then reflect the whole array
        // e.g. [1,2,|3,4] --> [2,1,|4,3] --> [3,4,1,2]
        int l = 0, r = k-1;
        while(l<r) {
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        l = k;
        r = nums.length-1;
        while(l<r) {
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        l = 0;
        r = nums.length-1;
        while(l<r) {
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
	}
	
}
