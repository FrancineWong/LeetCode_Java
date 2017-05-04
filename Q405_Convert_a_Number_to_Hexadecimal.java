import static org.junit.Assert.*;

import org.junit.Test;

/*Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, 
 * two’s complement method is used.

Note:

All letters in hexadecimal (a-f) must be in lowercase.
The hexadecimal string must not contain extra leading 0s. If the number is zero, it is 
represented by a single zero character '0'; otherwise, the first character in the hexadecimal 
string will not be the zero character.
The given number is guaranteed to fit within the range of a 32-bit signed integer.
You must not use any method provided by the library which converts/formats the number to hex directly.
Example 1:

Input:
26

Output:
"1a"
Example 2:

Input:
-1

Output:
"ffffffff"*/

//range of int: -2,147,483,648 to 2,147,483,647

public class Q405_Convert_a_Number_to_Hexadecimal {
//	public String toHex(int num) {
//        String result = "";
//        if(num<0) num = getTwosComplement(num);
//        System.out.println("Input:"+num);
//        if(num==0) return "0";
//        while(num!=0){
//        	result = charToHex(num%16)+result;
//        	num /= 16;
//        }
//        System.out.println("result:"+result);
//        return result;
//    }
//	
//	public char charToHex(int n){
//		return (char) (n<10?(n+'0'):('a'+n-10));
//	}
//	
//	public int getTwosComplement(int num){
//
//		String binary = "";
//		num = -num;
//		System.out.println("num:"+num);
//		while(num!=0){
//			binary = num%2 + binary;
//			num /= 2;
//		}
//		int n = binary.length();
//		for(int i=0; i<32-n; i++) binary = '0'+binary;
//		System.out.println("binary:"+binary);
//		
//		String complement = "";
//		for(int i=0; i<32; i++){
//			if(binary.charAt(i)=='0') complement += '1';
//			if(binary.charAt(i)=='1') complement += '0';
//		}
//		System.out.println("complement:"+complement);
//		
//		int decimal = 0;
//		for(int j=0; j<32; j++) if(complement.charAt(j)=='0') decimal += Math.pow(2, j);
//		System.out.println("decimal:"+decimal);
//		return decimal+1;
//	}
	/*handle four bit at one time*/
	/*同余，取模*/
	/*&: means bit and*/
	
	public String toHex(int num){
		if(num == 0) {
            return "0";
        }
        int bit[] = new int[10];
        int len = 0;
        String ans = "";
        for(int i=0; i<9; i++) {
            bit[i] = 0;
        }
        long n = num;
        n = n > 0? n : -n;
        while(n > 0) {
            bit[len++] = (int)n % 16;
            n /= 16;
        }
        if(num < 0) {
            for(int i=0; i<8; i++)
            {
                bit[i] = 15 - bit[i];
            }
            int pos = 0;
            while(bit[pos] == 15)
            {
                bit[pos] = 0;
                pos++;
            }
            bit[pos]++;
        }
        int leader0 = 1;
        for(int i=7; i>=0; i--)
        {    
            if(bit[i] != 0) leader0 = 0;
            if(leader0 == 1) continue;
            if(bit[i] < 10) ans += (char)('0' + bit[i]);
            else ans += (char)('a' + bit[i] - 10);
        }
        return ans;
	}
	
	@Test
	public void test(){
		assertEquals("1a", toHex(26));
	}
	
	@Test
	public void test1(){
		assertEquals("ffffffff", toHex(-1));
	}
	
	@Test
	public void test2(){
		assertEquals("10000000", toHex(-128));
	}
	
	@Test
	public void test3(){
		assertEquals("10000000000000000000000000000000", toHex(-2147483648));
	}
	
}
