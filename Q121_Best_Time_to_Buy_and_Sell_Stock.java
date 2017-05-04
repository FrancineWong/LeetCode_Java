import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.*/
public class Q121_Best_Time_to_Buy_and_Sell_Stock {
	//this solution takes O(N*N), too conplex
	public int maxProfit_1(int[] prices) {
		//排列组合，Cn2正差找最大, O(n*n)   
        int maxProfit = 0;
        int len = prices.length;
        for(int i=0; i<len-1; i++){
        	for(int j=i+1; j<len; j++){
        		if(prices[i]<prices[j]) maxProfit = (prices[j]-prices[i])>maxProfit?(prices[j]-prices[i]):maxProfit;
        	}
        }
        return maxProfit;
    }
	//O(n)
	public int maxProfit_2(int[] prices){
		if(prices.length==0) return 0;
		int profit = 0;
		int min = prices[0];
		for(int i=0; i<prices.length; i++){
			if(prices[i]<min) min = prices[i];
			if(profit<(prices[i]-min)) profit = prices[i]-min;
		}
		return profit;
	}
	//Kadane's Algorithm
	//Link:https://en.wikipedia.org/wiki/Maximum_subarray_problem
	/*The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm. Since no body 
	 * has mentioned this so far, I thought it's a good thing for everybody to know.

All the straight forward solution should work, but if the interviewer twists the question slightly by giving 
the difference array of prices, Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}, you might end up being confused.

Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, and 
find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.*/
	public int maxProfit(int[] prices){
		int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
            //maxCur = current maximum value
            //maxSoFar = maximum value found so far
        }
        return maxSoFar;
	}
	
	@Test
	public void test(){
		int[] prices = {};
		assertEquals(0, maxProfit(prices));
	}
}
