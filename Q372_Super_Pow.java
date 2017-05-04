/*Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive 
 * integer given in the form of an array.

Example1:

a = 2
b = [3]

Result: 8
Example2:

a = 2
b = [1,0]

Result: 1024*/
public class Q372_Super_Pow {
	/* 欧拉公式（英语：Euler's formula，又稱尤拉公式）是在複分析领域的公式，将三角函数與複數指数函数相关联，因其提出者莱昂哈德·欧拉而得名。
	 * 尤拉公式提出，對任意實数 {\displaystyle x} x，都存在
	{\displaystyle e^{ix}=\cos x+i\sin x} e^{ix} = \cos x + i\sin x
	 * One knowledge: ab % k = (a%k)(b%k)%k
	Since the power here is an array, we'd better handle it digit by digit.
	One observation:
	a^1234567 % k = (a^1234560 % k) * (a^7 % k) % k = (a^123456 % k)^10 % k * (a^7 % k) % k
	Looks complicated? Let me put it other way:
	Suppose f(a, b) calculates a^b % k; Then translate above formula to using f :
	f(a,1234567) = f(a, 1234560) * f(a, 7) % k = f(f(a, 123456),10) * f(a,7)%k;
	Implementation of this idea:
	*/
	public int superPow(int a, int[] b) {
	    if (a % 1337 == 0) return 0;
	    int p = 0;
	    for (int i : b) p = (p * 10 + i) % 1140;
	    if (p == 0) p += 1440;
	    return power(a, p, 1337);
	}
	public int power(int a, int n, int mod) {
	    a %= mod;
	    int ret = 1;
	    while (n != 0) {
	        if ((n & 1) != 0) ret = ret * a % mod;
	        a = a * a % mod;
	        n >>= 1;
	    }
	    return ret;
	}
}
