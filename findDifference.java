import static org.junit.Assert.*;

import org.junit.Test;

public class findDifference {
	public char findTheDifference(String s, String t){
		int[] sBuffer = new int[26];
		int[] tBuffer = new int[26];
		for(int i = 0; i<s.length(); i++){
			sBuffer[s.charAt(i)-97]++;
		}
		for(int j = 0; j<t.length(); j++){
			tBuffer[t.charAt(j)-97]++;
		}
		for(int k=0; k<26; k++){
			if(sBuffer[k]!=tBuffer[k])
				return (char) (k+97);
		}
		return '\0';
	}
	
	@Test
	public void test(){
		String a = "abcd", b = "abcde";
		assertEquals('e', findTheDifference(a, b ));
	}

}
