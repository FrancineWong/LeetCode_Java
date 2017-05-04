/*Count the number of prime numbers less than a non-negative number, n.*/
public class Q204_Count_Primes {
	public int countPrimes(int n) {
        int count = 0;
        if(n>=2) count++;
        for(int i=3; i<n; i+=2) {
        	if(isPrime(i)) count++;
        }
        return count;
    }
	
	public boolean isPrime(int n) {
		if(n==3) return true;
		for(int i=3; i<Math.sqrt(n); i+=2) {
			if(n%i==0) return false;
		}
		return true;
	}
	
	//it starts from 2, the first prime, then mark the multip of 2 as true in notPrime, so the loop of 
	//i will skip them. the next prime is 3, do the same thing. Then it is 4, which 2*2, so the not prime is
	//true, and will skip to next.
	public int countPrimes_0(int n) {
		boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
	}
}
