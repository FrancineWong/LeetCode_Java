/*Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.*/
public class Q152_Maximum_Product_Subarray {
	public int maxProduct(int[] nums) {
        int n = nums.length;
        if(nums==null||nums.length==0) return 0;
        for(int i = 0; i<n; i++) {
        	
        }
        return 0;
    }
/******************************************************************************************/
	public int maxProduct_0(int[] nums) {
		if (nums.length == 0) {
	        return 0;
	    }
	    
	    int maxherepre = nums[0];
	    int minherepre = nums[0];
	    int maxsofar = nums[0];
	    int maxhere, minhere;
	    
	    for (int i = 1; i < nums.length; i++) {
	        maxhere = Math.max(Math.max(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
	        minhere = Math.min(Math.min(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
	        maxsofar = Math.max(maxhere, maxsofar);
	        maxherepre = maxhere;
	        minherepre = minhere;
	    }
	    return maxsofar;
	}
}
