
public class Q402_Remove_K_Digits {
	public String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        char[] stk = new char[num.length()];
        int top = 0;
        // k keeps track of how many characters we can remove
        // if the previous character in stk is larger than the current one
        // then removing it will get a smaller number
        // but we can only do so when k is larger than 0
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (top > 0 && stk[top-1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            stk[top++] = c;
        }
        // find the index of first non-zero digit
        int idx = 0;
        while (idx < digits && stk[idx] == '0') idx++;
        return idx == digits? "0": new String(stk, idx, digits - idx);
    }
	/*这道题让我们将给定的数字去掉k位，要使得留下来的数字最小，这题跟LeetCode上之前那道Create Maximum Number有些类似，
	 * 可以借鉴其中的思路，如果n是num的长度，我们要去除k个，那么需要剩下n-k个，我们开始遍历给定数字num的每一位，对于当前遍历到的数字c，
	 * 进行如下while循环，如果res不为空，且k大于0，且res的最后一位大于c，那么我们应该将res的最后一位移去，且k自减1。当跳出while循环
	 * 后，我们将c加入res中，最后我们将res的大小重设为n-k。根据题目中的描述，可能会出现"0200"这样不符合要求的情况，所以我们用一个
	 * while循环来去掉前面的所有0，然后返回时判断是否为空，为空则返回“0”，参见代码如下：*/
	public String removeKdigits_0(String num, int k) {
        String res = "";
        int n = num.length(), keep = n - k;
        for (int i=0 ;i<n; i++) {
        	char c = num.charAt(i);
            while (k>0 && res.length()>0 && res.charAt(res.length()-1) > c) {
                res.pop_back();
                --k;
            }
            res.push_back(c);
        }
        res.resize(keep);
        while (!res.empty() && res[0] == '0') res.erase(res.begin());
        return res.empty() ? "0" : res;
    }
}
