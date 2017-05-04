/*Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1*/
/*实现next permutation（下一个排列），重新排列数组中的数，使得到的新数组的字典序恰好大于原数组。如果不存在这样的排列，
 * 就将原数组从小到大排序。替换必须就地进行，不要分配额外的内存。*/
/*首先从右向左遍历数组，找到第一个相邻的左<右的数对，记右下标为x，则左下标为x - 1, 若x > 0，则再次从右向左遍历数组，
 * 直到找到第一个大于nums[x - 1]的数字为止，记其下标为y，交换nums[x - 1], nums[y],最后将nums[x]及其右边的元素就地逆置*/
public class Q031_Next_Permutation {
	/* 1. Start from its last element, traverse backward to find the first one with index i that satisfy 
	 * num[i-1] < num[i]. So, elements from num[i] to num[n-1] is reversely sorted.
	 * 2. To find the next permutation, we have to swap some numbers at different positions, to minimize the 
	 * increased amount, we have to make the highest changed position as high as possible. 
	 * Notice that index larger than or equal to i is not possible as num[i,n-1] is reversely sorted. 
	 * So, we want to increase the number at index i-1, clearly, swap it with the smallest number 
	 * between num[i,n-1] that is larger than num[i-1]. For example, original number is 121543321, 
	 * we want to swap the '1' at position 2 with '2' at position 7.
	 * 3. The last step is to make the remaining higher position part as small as possible, we just have to 
	 * reversely sort the num[i,n-1]*/
	public void nextPermutation(int[] nums) {
		int n=nums.length;
	    if(n<2)
	        return;
	    int index=n-1;        
	    while(index>0){
	        if(nums[index-1]<nums[index])
	            break;
	        index--;
	    }
	    if(index==0){
	        reverseSort(nums,0,n-1);
	        return;
	    }
	    else{
	        int val=nums[index-1];
	        int j=n-1;
	        while(j>=index){
	            if(nums[j]>val)
	                break;
	            j--;
	        }
	        swap(nums,j,index-1);
	        reverseSort(nums,index,n-1);
	        return;
	    }
    }
	public void swap(int[] num, int i, int j){
	    int temp=0;
	    temp=num[i];
	    num[i]=num[j];
	    num[j]=temp;
	}

	public void reverseSort(int[] num, int start, int end){   
	    if(start>end)
	        return;
	    for(int i=start;i<=(end+start)/2;i++)
	        swap(num,i,start+end-i);
	}
}
