import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

/*Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.*/
public class Q205_Isomorphic_Strings {
	public boolean isIsomorphic_0(String s, String t) {
		//如果遇到所有字幕的个数都一样就无法区别
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
		
		for(int i=0 ;i<s.length(); i++) {
			sMap.put(s.charAt(i), 0);
			tMap.put(t.charAt(i), 0);
		}
		for(int i=0; i<s.length(); i++) {
			sMap.put(s.charAt(i), sMap.get(s.charAt(i))+1);
			tMap.put(t.charAt(i), tMap.get(t.charAt(i))+1);
		}
		
		for(int i=0; i<s.length(); i++) {
//			sBuf[i] = sMap.get(s.charAt(i));
//			System.out.println(sBuf[i]);
//			tBuf[i] = tMap.get(t.charAt(i));
//			System.out.println(tBuf[i]);
			System.out.println(sMap.get(s.charAt(i)));
			System.out.println(tMap.get(t.charAt(i)));
			if(sMap.get(s.charAt(i))!=tMap.get(t.charAt(i))) return false;
		}
		
        return true;
    }
	
	public boolean isIsomorphic(String s, String t) {
		//amount, index
		int[] sBuf = new int[256];
		int[] tBuf = new int[256];
		for(int i=0; i<s.length(); i++) {
			if(sBuf[s.charAt(i)]!=tBuf[t.charAt(i)]) return false;
			sBuf[s.charAt(i)] = i+1;
			tBuf[t.charAt(i)] = i+1;
		}
 		return true;
	}
	@Test
	public void test_0() {
		assertEquals(true, isIsomorphic("paper", "title"));
	}
	
	@Test
	public void test_1() {
		assertEquals(false, isIsomorphic("abba", "cdcd"));
	}
	
}
