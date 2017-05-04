import java.util.ArrayList;
import java.util.List;

/*The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.*/
public class Q089_Gray_Code {
	//n==1, 0,1
	/*假设原始的值从0开始，格雷码产生的规律是：第一步，改变最右边的位元值；第二步，改变右起第一个为1的位元的左边位元；第三步，第四步重复第一步和第二步，
	 * 直到所有的格雷码产生完毕（换句话说，已经走了(2^n) - 1 步）。*/
	public String[] GrayCode(int n) {  
		  
	    // produce 2^n grade codes  
	    String[] graycode = new String[(int) Math.pow(2, n)];  
	  
	    if (n == 1) {  
	        graycode[0] = "0";  
	        graycode[1] = "1";  
	        return graycode;  
	    }  
	  
	    String[] last = GrayCode(n - 1);  
	  
	    for (int i = 0; i < last.length; i++) {  
	        graycode[i] = "0" + last[i];  
	        graycode[graycode.length - 1 - i] = "1" + last[i];  
	    }  
	  
	    return graycode;  
	}  
	
	/******************************************************************************************************************/
	/*格雷码还有一种实现方式是根据这个公式来的 G(n) =  B(n) XOR B(n+1), 这也是格雷码和二进制码的转换公式*/
	public List<Integer> grayCode_0(int n) {
		List<Integer> result = new ArrayList<Integer>();
	    for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
	    return result;
	}
	
	/**************************************/
	public List<Integer> grayCode_1(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
	    result.add(0);
	    for(int i=0;i<n;i++){
	        int inc = 1<<i;
	        for(int j=result.size()-1;j>=0;j--){
	            result.add(result.get(j)+inc);
	        }
	    }
	    return result;
	}
}
	/******************************************************************************************************************/
	/*
    The purpose of this function is to convert an unsigned
    binary number to reflected binary Gray code.

    The operator >> is shift right. The operator ^ is exclusive or.
*/
	
//	public unsigned int binaryToGray(unsigned int num)
//	{
//	    return (num >> 1) ^ num;
//	}
//	
//	/*
//	    The purpose of this function is to convert a reflected binary
//	    Gray code number to a binary number.
//	*/
//	public unsigned int grayToBinary(unsigned int num)
//	{
//		public unsigned int mask;
//		for (mask = num >> 1; mask != 0; mask = mask >> 1)
//		{
//		    num = num ^ mask;
//		}
//		return num;
//		}
//	}
