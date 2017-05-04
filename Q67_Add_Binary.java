import static org.junit.Assert.*;

import org.junit.Test;

/*Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".*/
public class Q67_Add_Binary {
	public String addBinary(String a, String b) {
        StringBuilder ret = new StringBuilder();
        int dec_a = 0, dec_b = 0, dec_sum = 0;
        for(int i=a.length()-1; i>=0; i--) {
        	dec_a = (int) ((a.charAt(i)-'0')*Math.pow(2, i-a.length()-'0'+1));
        }
        for(int i=b.length()-1; i>=0; i--) {
        	dec_b = (int) ((b.charAt(i)-'0')*Math.pow(2, i-b.length()-'0'+1));
        }
        dec_sum = dec_a+dec_b;
        while(dec_sum>0) {
        	ret.insert(0, (char)(dec_sum%2+'0'));
        }
        return ret.toString();
    }
	
	@Test
	public void test() {
		assertEquals("100", addBinary("11", "1"));
	}
	
	public String assBinary_1(String a, String b) {
//		StringBuilder ret = new StringBuilder();
		String ret = "";
		int index_a = a.length()-1, index_b = b.length()-1, cr = 0;
		while(index_a>=0||index_b>=0) {
			int ta = index_a>=0?(int)(a.charAt(index_a--)-'0'):0;
			int tb = index_b>=0?(int)(b.charAt(index_b--)-'0'):0;
			ret = (char)((ta+tb)%2+cr+'0')+ret;
			cr = (ta+tb+cr)/2;
		}
		if(cr==1) ret = '1' + ret;
		
		return ret;
	}
	
	@Test
	public void test_1() {
		assertEquals("100", addBinary("11", "1"));
	}
	
}
