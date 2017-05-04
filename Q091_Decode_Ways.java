import static org.junit.Assert.*;

import org.junit.Test;

/*A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.*/
/*public String substring(int startIndex, int endIndex): This method returns new String object containing
 *  the substring of the given string from specified startIndex to endIndex.
In case of string:

startIndex: inclusive
endIndex: exclusive*/
public class Q091_Decode_Ways {
	/*****wrong answer********/
	//总是少一， corner case
	public int numDecodings(String s) {
		int len = s.length();
		if(len == 0) return 0;
		else if(len == 1) return 1;
		if(str2num(s.substring(len-2, len))<=26) return numDecodings(s.substring(0, len-1))+numDecodings(s.substring(0,  len-2));
		else return numDecodings(s.substring(0, len-1));
    }
	public int str2num(String s) {
		int num = 0;
		for( int i=0; i<s.length(); i++) {
			num = num*10 + (s.charAt(i)-'0');
		}
		return num;
	}
	
	@Test
	public void test_0() {
		assertEquals(12, str2num("12"));
	}
	@Test
	public void test_1() {
		assertEquals(1, str2num("1"));
	}
	/**********************************************************************************************************************/
	public int numDecoding_0(String s) {
		int n = s.length();
        if (n == 0) return 0;
        
        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
        
        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
        
        return memo[0];
	}
	/***********************************************************************************************************************/
	public int numDecodings_1(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
