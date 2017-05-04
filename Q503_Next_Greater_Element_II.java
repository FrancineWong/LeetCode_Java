import java.util.Arrays;
import java.util.Stack;

public class Q503_Next_Greater_Element_II {
	/*遍历两倍的数组，然后还是坐标i对n取余，取出数字，如果此时栈不为空，且栈顶元素小于当前数字，说明当前数字就是栈顶元素的右边第一个较大数，
	 * 那么建立二者的映射，并且去除当前栈顶元素，最后如果i小于n，则把i压入栈。因为res的长度必须是n，超过n的部分我们只是为了给之前栈中的数
	 * 字找较大值，所以不能压入栈*/
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length, next[] = new int[n];
		Arrays.fill(next, -1);
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<n*2; i++) {
			int num = nums[i%n];
			while(!stack.isEmpty()&&nums[stack.peek()]<num)
				next[stack.pop()] = num;
			if(i<n) stack.push(i);
		}
		return next;
    }
}
