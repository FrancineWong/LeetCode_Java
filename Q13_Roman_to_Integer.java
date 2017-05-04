import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

/*Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.*/

public class Q13_Roman_to_Integer {
	
	public HashMap<Character, Integer> roman = new HashMap<Character, Integer>();
	
	public int romanToInt(String s) {
		if(s=="") return 0;
        int result = 0;
        int i = 0;
        initializeRoman();
        for(i=0; i<s.length()-1; i++){
            if(roman.get(s.charAt(i))*5==roman.get(s.charAt(i+1))||roman.get(s.charAt(i))*10==roman.get(s.charAt(i+1))) {
        		result += roman.get(s.charAt(i+1))-roman.get(s.charAt(i));
        		i++;
        	}else result += roman.get(s.charAt(i));
        }
        if(i==(s.length()-1)) result += roman.get(s.charAt(i));
        return result;
    }
	
	public void initializeRoman(){
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);
	}
	
	@Test
	public void test(){
		String input = "MCMLIV";
		assertEquals(1954, romanToInt(input));
	}
	
	@Test
	public void test1(){
		String input  = "MCMXC";
		assertEquals(1990, romanToInt(input));
	}
	
}
