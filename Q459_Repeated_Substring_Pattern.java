import static org.junit.Assert.*;

import org.junit.Test;

/*Given a non-empty string check if it can be constructed by taking a substring of it and appending
 *  multiple copies of the substring together. You may assume the given string consists of lowercase 
 *  English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)*/

/*
 * 1.The length of the repeating substring must be a divisor of the length of the input string
2.Search for all possible divisor of str.length, starting for length/2
3.If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
4.If the repeated substring is equals to the input str return true*/

public class Q459_Repeated_Substring_Pattern {
	public boolean repeatedSubstringPattern(String str){
		int len = str.length();
		for(int i = len/2; i>=1; i--){
			if(len%i==0){
				int m = len/i;
				String sub = str.substring(0,i);
				int j=0;
				for(j=1; j<m; j++){
					if(!sub.equals(str.substring(i*j, i+i*j))) break;
				}
				if(j==m) return true;
			}
		}
		return false;
	}
	public boolean repeatedSubstringPattern_1(String str) {
		int len = str.length();
		if(len <2) return false;
		int p = len/2;
		int i=0;
		for(i=0; i<p; i++){
			if(str.length()%p!=0) {
				p--;
				continue;
			}
			int n = len/p;
			for(int j=1; j<n; j++){
				if(str.charAt(i)!=str.charAt(i+p*j)) {
					p--;
					continue;
				}
			}
		}
		if(i==p) return true;
		return false;
    }
	
	@Test
	public void test(){
		assertEquals(true, repeatedSubstringPattern("abab"));
	}
	@Test
	public void test1(){
		assertEquals(false, repeatedSubstringPattern("aba"));
	}
	@Test
	public void test2(){
		assertEquals(true, repeatedSubstringPattern("aaaaaaaaaaaaaaaa"));
	}
	@Test
	public void test3(){
		assertEquals(false, repeatedSubstringPattern("aabaaba"));
	}
	@Test
	public void test4(){
		assertEquals(false, repeatedSubstringPattern("ababac"));
	}
}
