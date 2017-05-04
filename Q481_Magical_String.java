
public class Q481_Magical_String {
	/*分析：直接按照这个字符串的构造方法还原这个字符串s：首先初始化s = “122”,让index指向下标为2处，开始根据index指向的字符在s后面添加字符串
	 * 如果指向的是2就添加2个，如果指向的是1就添加一个，具体添加什么字符以当前s的末尾一位的字符是1还是2为准，如果s当前最后一个字符是1就添加2，
	 * 反之添加1～还原好了之后用count直接计算字符串从begin()到n长度处一共有多少个’1’字符～～*/
	public int magicString(int n) {
		if(n<=0) return 0;
		if(n<=3) return 1;
		int res = 1, head = 2, tail = 3, num = 1;
		int[] v = new int[n+1];
		v[0] = 1; v[1] = 2; v[2] = 2;
		while(tail<n) {
			for(int i=0; i<v[head]; i++) {
				v[tail] = num;
				if(num==1&&tail<n) res++;
				tail++;
			}
			num ^= 3; //A trick to flip number back and forth between 1 and 2: num = num ^ 3
			head++;
		}
		return res;
	}
	
}
