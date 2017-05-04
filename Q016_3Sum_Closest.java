import java.util.Arrays;

/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, 
 * target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/
public class Q016_3Sum_Closest {
	public int threeSumClosest(int[] nums, int target) {

		int closSum = 0;
		Arrays.sort(nums);
		if(nums.length<=3) {
		    int res = 0;
		    for(int i: nums) {
		        res += i;
		    }
		    return res;
		}
		closSum = nums[0] + nums[1] + nums[2];
		for(int i=0; i<nums.length-2; i++) {
			int l = i+1, h=nums.length-1;
			while(l<h) {
				int sum = nums[i] + nums[l] + nums[h];
				if(Math.abs(target-sum)<Math.abs(target-closSum)) {
					closSum = sum;
					if(sum == target) return sum;
				}
				if(sum>target) h--;
				else l++;
			}
		}
        return closSum;
    }
/*URL:http://stackoverflow.com/questions/2070359/finding-three-elements-in-an-array-whose-sum-is-closest-to-a-given-number*/
	
}
