/*F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]
F(k-1) = 0 * Bk-1[0] + 1 * Bk-1[1] + ... + (n-1) * Bk-1[n-1]
       = 0 * Bk[1] + 1 * Bk[2] + ... + (n-2) * Bk[n-1] + (n-1) * Bk[0]
Then,

F(k) - F(k-1) = Bk[1] + Bk[2] + ... + Bk[n-1] + (1-n)Bk[0]
              = (Bk[0] + ... + Bk[n-1]) - nBk[0]
              = sum - nBk[0]
Thus,

F(k) = F(k-1) + sum - nBk[0]
What is Bk[0]?

k = 0; B[0] = A[0];
k = 1; B[0] = A[len-1];
k = 2; B[0] = A[len-2];
...*/
public class Q396_Rotate_Function {
	public int maxRotateFunction(int[] A) {
        int max = 0;
        //A.length == 0
        for(int i=0; i<A.length; i++) {
        	int F = 0;
        	for(int j=0; j<A.length; j++) {
        		F += j*A[(j+i)%A.length];
        	}
        	max = F>max?F:max;
        }
        return max;
    }
	
	public int maxRotateFunction_0(int[] A) {
		int F = 0, sum = 0;
		for(int i=0; i<A.length; i++) {
			F += i*A[i];
			sum += A[i];
		}
		int max = F;
		for(int i=A.length-1; i>=1; i--) {
			F = F + sum - A.length * A[i];
			max = F>max?F:max;
		}
		return max;
	}
}
