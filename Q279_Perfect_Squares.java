import java.util.ArrayList;
import java.util.List;

/*Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 *  which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.*/
public class Q279_Perfect_Squares {
	int minCount = 0;
	public int numSquares(int n) {
		int len = (int) Math.sqrt(n);
		int count = 0;
		if(n-len*len==0) return ++count;
		while(n>0) {
			
		}
        return count;
    }
	//link:https://discuss.leetcode.com/topic/24255/summary-of-4-different-solutions-bfs-dp-static-dp-and-mathematics/6
	/*******************************    Dynamic Programming    ******************************************/
	public int numSquares_0(int n) 
	    {
	        if (n <= 0)
	        {
	            return 0;
	        }	        
	        // cntPerfectSquares[i] = the least number of perfect square numbers 
	        // which sum to i. Note that cntPerfectSquares[0] is 0.
	        int[] cntPerfectSquares = new int[n+1];
			for(int i=0; i<n+1; i++) cntPerfectSquares[i] = Integer.MAX_VALUE;
	        cntPerfectSquares[0] = 0;
	        for (int i = 1; i <= n; i++)
	        {
	            // For each i, it must be the sum of some number (i - j*j) and 
	            // a perfect square number (j*j).
	            for (int j = 1; j*j <= i; j++)
	            {
	                cntPerfectSquares[i] = 
	                    Math.min(cntPerfectSquares[i], cntPerfectSquares[i - j*j] + 1);
	            }
	        }	        
	        return cntPerfectSquares[n];
	    }
	
	//static dynamic programming
	public int sunSquares_1(int n) {
		/*static vector<int> cntPerfectSquares({0});
        
        // While cntPerfectSquares.size() <= n, we need to incrementally 
        // calculate the next result until we get the result for n.
        while (cntPerfectSquares.size() <= n)
        {
            int m = cntPerfectSquares.size();
            int cntSquares = INT_MAX;
            for (int i = 1; i*i <= m; i++)
            {
                cntSquares = min(cntSquares, cntPerfectSquares[m - i*i] + 1);
            }
            
            cntPerfectSquares.push_back(cntSquares);
        }
        
        return cntPerfectSquares[n];*/
		List<Integer> countSquares = new ArrayList<Integer>();
		countSquares.add(0);
		if(n<=0) return 0;
		while(countSquares.size()<=n) {
			int m = countSquares.size();
			int count  = Integer.MAX_VALUE;
			for(int i = 1; i*i<=m; i++) {
				count = Math.min(count, countSquares.get(m-i*i)+1);
			}
			countSquares.add(count);
		}
		
		return countSquares.get(n);
	}
	/***************************     Math Solution      **********************************/
	private  
	    boolean is_square(int n)
	    {  
	        int sqrt_n = (int)(Math.sqrt(n));  
	        return sqrt_n*sqrt_n == n;  
	    }
	    
	public
	    // Based on Lagrange's Four Square theorem, there 
	    // are only 4 possible results: 1, 2, 3, 4.
	    int numSquares_1(int n) 
	    {  
	        // If n is a perfect square, return 1.
	        if(is_square(n)) 
	        {
	            return 1;  
	        }
	        
	        // The result is 4 if and only if n can be written in the 
	        // form of 4^k*(8*m + 7). Please refer to 
	        // Legendre's three-square theorem.
	        while ((n & 3) == 0) // n%4 == 0  
	        {
	            n >>= 2;  
	        }
	        if ((n & 7) == 7) // n%8 == 7
	        {
	            return 4;
	        }
	        
	        // Check whether 2 is the result.
	        int sqrt_n = (int)(Math.sqrt(n)); 
	        for(int i = 1; i <= sqrt_n; i++)
	        {  
	            if (is_square(n - i*i)) 
	            {
	                return 2;  
	            }
	        }  
	        
	        return 3;  
	    } 
	
}
