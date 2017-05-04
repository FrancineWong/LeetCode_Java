import static org.junit.Assert.*;

import org.junit.Test;

public class addDigits {
	public int addDigits(int num){
		while(num/10!=0){
			num = num/10+num%10;
			return addDigits(num);
		}
		return num;
	}
	
	@Test
	public void test(){
		int a = 38;
		assertEquals(2, addDigits(a));
	}
}
