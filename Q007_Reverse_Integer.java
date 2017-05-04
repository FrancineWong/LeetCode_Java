
public class Q007_Reverse_Integer {
	//no overflow check. worng
	public int reverse(int x) {
        int rev = 0;
        while(x!=0) {
        	rev = 10*rev + x%10;
        	x /= 10;
        }
        return rev;
    }
	
	//overflow check
	public int reverse_0(int x) {
		int result = 0;

	    while (x != 0)
	    {
	        int tail = x % 10;
	        int newResult = result * 10 + tail;
	        if ((newResult - tail) / 10 != result)
	        { return 0; }
	        result = newResult;
	        x = x / 10;
	    }

	    return result;
	}
}
