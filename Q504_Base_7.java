
public class Q504_Base_7 {
	public String convertToBase7(int num) {
		if(num==0) return "0";
        StringBuilder res = new StringBuilder();
        boolean isNag = num<0;
        int n = isNag?(-num):num;
        while(n!=0) {
        	res.insert(0, n%7);
        	n /= 7;
        }
        if(isNag) res.insert(0, '-');
        return res.toString();
    }
}
