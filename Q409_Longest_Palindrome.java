import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*Given a string which consists of lowercase or uppercase letters, find the length of 
 * the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

*/

public class Q409_Longest_Palindrome {
	public int longestPalindrome(String s) {
		int result = 0;
		int odd = 0;
        HashMap<Character, Integer> mark = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++) mark.put(s.charAt(i), 0);
        for(int i=0; i<s.length(); i++) mark.put(s.charAt(i), mark.get(s.charAt(i))+1);
        
        for(Map.Entry<Character, Integer> entry:mark.entrySet()){
        	if(entry.getValue()%2==0){
        		result += entry.getValue();
        	}else{
        		result += entry.getValue()-1;
        		odd++;
        	}
        }
        return (odd==0?0:1)+result;
    }
	
	@Test
	public void test(){
		assertEquals(9, longestPalindrome("ababababa"));
	}
	@Test
	public void test1(){
		assertEquals(4, longestPalindrome("aaaa"));
	}
	
	@Test
	public void test2(){
		assertEquals(3, longestPalindrome("ccc"));
	}
	
	@Test
	public void test3(){
		assertEquals(12, longestPalindrome("tattarrattat"));
	}

}
