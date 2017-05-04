import java.util.HashSet;
import java.util.Set;

/*Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.*/
public class Q421_Maximum_XOR_of_Two_Numbers_in_an_Array {
	/*这道题是一道典型的位操作Bit Manipulation的题目，我开始以为异或值最大的两个数一定包括数组的最大值，但是OJ给了另一个例子
	 * {10,23,20,18,28}，这个数组的异或最大值是10和20异或，得到30。那么只能另辟蹊径，正确的做法是按位遍历，题目中给定了数字的返回不会
	 * 超过231,那么最多只能有32位，我们用一个从左往右的mask，用来提取数字的前缀，然后将其都存入set中，我们用一个变量t，用来验证当前位为
	 * 1再或上之前结果res，看结果和set中的前缀异或之后在不在set中，这里用到了一个性质，若a^b=c，那么a=b^c，因为t是我们要验证的当前最大值，
	 * 所以我们遍历set中的数时，和t异或后的结果仍在set中，说明两个前缀可以异或出t的值，所以我们更新res为t，继续遍历，如果上述讲解不容易理解，
	 * 那么建议自己带个例子一步一步试试，并把每次循环中set中所有的数字都打印出来，基本应该就能理解了，参见代码如下：*/
	public int findMaximumXOR(int[] nums) {
		int max = 0, mask = 0;
		for(int i=31; i>-0; i--) {
			mask = mask|(i<<i);
			Set<Integer> set = new HashSet<>();
			for(int num:nums) {
				set.add(num&mask);
			}
			int tmp = max|(1<<i);
			for(int prefix:set) {
				if(set.contains(tmp^prefix)) {
					max = tmp;
					break;
				}
			}
		}
        return max;
    }
}
