import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a positive integer n, break it into the sum of at least two positive integers and maximize the 
 * product of those integers. Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * Note: You may assume that n is not less than 2 and not larger than 58.*/

public class Q343_Integer_Break {
	
	/*我们可以看出从5开始，数字都需要先拆出所有的3，一直拆到剩下一个数为2或者4，因为剩4就不用再拆了，拆成两个2和不拆没有意义，
	 * 而且4不能拆出一个3剩一个1，这样会比拆成2+2的乘积小。那么这样我们就可以写代码了，先预处理n为2和3的情况，然后先将结果res初始化为1，
	 * 然后当n大于4开始循环，我们结果自乘3，n自减3，根据之前的分析，当跳出循环时，n只能是2或者4，再乘以res返回即可*/
	public int integerBreak_0(int n) {
        if (n == 2 || n == 3) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
	/*我们再来观察上面列出的10之前数字的规律，我们还可以发现数字7拆分结果是数字4的三倍，而7比4正好大三，数字8拆分结果是数字5的三倍，
	 * 而8比5大3，后面都是这样的规律，那么我们可以把数字6之前的拆分结果都列举出来，然后之后的数通过查表都能计算出来
	 * */
	public int integerBreak_1(int n) {
		List<Integer> dp = new ArrayList<Integer>(Arrays.asList(0, 0, 1,2,4,6,9));
        for (int i = 7; i <= n; ++i) {
            dp.add(3 * dp.get(i-3));
        }
        
        return dp.get(n);
    }
}
