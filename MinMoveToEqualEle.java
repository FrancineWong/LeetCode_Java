import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

//Given a non-empty integer array of size n, find the minimum number of moves required to make all 
//array elements equal, where a move is incrementing n - 1 elements by 1.
/*
 * 一次移动将n - 1个元素加1，等价于将剩下的1个元素减1。

因此累加数组中各元素与最小值之差即可。
*/

/*Best solotion
 * public int minMoves(int[] nums) {
        int times = 0;
        int min = minVal(nums);
        for(int i:nums) times += i - min;
        return times;
    }
    public int minVal(int[] nums){
        int min = nums[0];
        for(int i:nums) if(i<=min) min = i;
        return min;
    }*/

public class MinMoveToEqualEle {
	public int minMoves(int[] nums) {
		int times = 0;
		Arrays.sort(nums);
		while(nums[0]!=nums[nums.length-1]){
			for(int i = 0; i<nums.length-1; i++){
				nums[i]++;
			}
			times++;
			Arrays.sort(nums);
		}
        return times;
    }
	
//	public int maxIndex(int[] nums){
//		int maxIndex = 0;
//		for(int i = 0; i<nums.length; i++){
//			if(nums[i]>=nums[maxIndex]){
//				maxIndex = i;
//			}
//		}
//		return maxIndex;
//	}
	
	public boolean isEqual(int[] nums){
		for(int i=0; i<nums.length-1; i++){
			if(nums[i]!=nums[i+1]) return false;
		}
		return true;
	}
	
	@Test
	public void test(){
		int[] t = {1,2,3};
		assertEquals(3, minMoves(t));
	}
}
