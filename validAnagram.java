import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

/*Given two strings s and t, write a function to determine if t is an anagram of s.
相同字母异序
For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?*/

public class validAnagram {
	public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] sBuffer = new int[26];
        int[] tBuffer = new int[26];
        for(int i=0; i<26; i++) {
        	sBuffer[i]=0;
        	tBuffer[i]=0;
        }
        for(int i=0; i<s.length(); i++) {
        	sBuffer[s.charAt(i)-97]++;
        	tBuffer[t.charAt(i)-97]++;
        }
        return Arrays.equals(sBuffer, tBuffer);
        
//        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
//        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
//        for(int i=0; i<s.length(); i++){
//        	sMap.put(s.charAt(i), 0);
//        	tMap.put(t.charAt(i), 0);
//        }
//        for(int i=0; i<s.length(); i++){
//        	sMap.put(s.charAt(i), sMap.get(s.charAt(i))+1);
//        	tMap.put(t.charAt(i), tMap.get(t.charAt(i))+1);
//        }
//        return sMap.equals(tMap);
    }
	
	@Test 
	public void test(){
		assertEquals(true, isAnagram("anagram", "nagaram"));
	}
	
	@Test
	public void test1(){
		assertEquals(true, isAnagram("a", "a"));
	}
	
	public void main(String argv){
		String a = "a";
		String b = "a";
		System.out.println(isAnagram(a, b));
	}
	
}
