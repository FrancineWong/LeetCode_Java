import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/*Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".

*/
//find all the vowels as a string and reverse to reset to original index

public class Q345_Reverse_Vowels_of_a_String {
	public String reverseVowels(String s) {
        List<Character> vwl = new ArrayList<Character>();
        vwl.add('a');
        vwl.add('e');
        vwl.add('i');
        vwl.add('o');
        vwl.add('u');
        vwl.add('A');
        vwl.add('E');
        vwl.add('I');
        vwl.add('O');
        vwl.add('U');
        
        List<Character> ky = new ArrayList<Character>();
        StringBuilder t = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
        	if(vwl.contains(t.charAt(i))){
        		ky.add(t.charAt(i));
        	}
        }
        int index = 0;
        for(int i=s.length()-1; i>=0; i--){
        	if(vwl.contains(t.charAt(i))){
        		t.setCharAt(i, ky.get(index++));
        	}
        }
        
        return t.toString();
    }
	
	public String reverseVowels_1(String s){
		List<Character> vwl = new ArrayList<Character>();
        vwl.add('a');
        vwl.add('e');
        vwl.add('i');
        vwl.add('o');
        vwl.add('u');
        vwl.add('A');
        vwl.add('E');
        vwl.add('I');
        vwl.add('O');
        vwl.add('U');
        
		int hd = 0;
		int tl = s.length()-1;
		StringBuilder t = new StringBuilder(s);
		while(hd<s.length()&&tl>=0){
			while(!vwl.contains(t.charAt(hd))) hd++;
			while(!vwl.contains(t.charAt(tl))) tl--;
			t.setCharAt(hd++, t.charAt(tl--));
		}
		return t.toString();
	}
	
	public String reverseVowels_2(String s) {
	    if(s == null || s.length()==0) return s;
	    String vowels = "aeiouAEIOU";
	    char[] chars = s.toCharArray();
	    int start = 0;
	    int end = s.length()-1;
	    while(start<end){
	        
	        while(start<end && !vowels.contains(chars[start]+"")){
	            start++;
	        }
	        
	        while(start<end && !vowels.contains(chars[end]+"")){
	            end--;
	        }
	        
	        char temp = chars[start];
	        chars[start] = chars[end];
	        chars[end] = temp;
	        
	        start++;
	        end--;
	    }
	    return new String(chars);
	}
	
	@Test
	public void test(){
		assertEquals("uoiea", reverseVowels_1("aeiou"));
	}
	
	@Test
	public void test_1(){
		assertEquals("manfin", reverseVowels_1("minfan"));
	}
	
}
