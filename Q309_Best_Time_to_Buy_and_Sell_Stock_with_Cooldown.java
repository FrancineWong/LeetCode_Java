/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one 
and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
*/
public class Q309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
	public int maxProfit(int[] prices) {
		int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
	    for (int price : prices) {
	        prev_buy = buy;
	        buy = Math.max(prev_sell - price, prev_buy);
	        prev_sell = sell;
	        sell = Math.max(prev_buy + price, prev_sell);
	    }
	    return sell;
    }
	/**************************************************************************************/
	/*There are three states, according to the action that you can take.

	Hence, from there, you can now the profit at a state at time i as:
	
	s0[i] = max(s0[i - 1], s2[i - 1]); // Stay at s0, or rest from s2
	s1[i] = max(s1[i - 1], s0[i - 1] - prices[i]); // Stay at s1, or buy from s0
	s2[i] = s1[i - 1] + prices[i]; // Only one way from s1
	Then, you just find the maximum of s0[n] and s2[n], since they will be the maximum profit we need 
	(No one can buy stock and left with more profit that sell right :) )
	
	Define base case:
	
	s0[0] = 0; // At the start, you don't have any stock if you just rest
	s1[0] = -prices[0]; // After buy, you should have -prices[0] profit. Be positive!
	s2[0] = INT_MIN; // Lower base case*/
	public int maxProfit_0(int[] prices){
		if (prices.length <= 1) return 0;
		int[] s0 = new int[prices.length];
		int[] s1 = new int[prices.length];
		int[] s2 = new int[prices.length];
		s1[0] = -prices[0];
		s0[0] = 0;
		s2[0] = Integer.MIN_VALUE;
		for (int i = 1; i < prices.length; i++) {
			s0[i] = Math.max(s0[i - 1], s2[i - 1]);
			s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
			s2[i] = s1[i - 1] + prices[i];
		}
		return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
	}
}

/*The series of problems are typical dp. The key for dp is to find the variables to represent the states and 
 * deduce the transition function.

Of course one may come up with a O(1) space solution directly, but I think it is better to be generous when you 
think and be greedy when you implement.

The natural states for this problem is the 3 possible transactions : buy, sell, rest. Here rest means no 
transaction on that day (aka cooldown).

Then the transaction sequences can end with any of these three states.

For each of them we make an array, buy[n], sell[n] and rest[n].

buy[i] means before day i what is the maxProfit for any sequence end with buy.

sell[i] means before day i what is the maxProfit for any sequence end with sell.

rest[i] means before day i what is the maxProfit for any sequence end with rest.

Then we want to deduce the transition functions for buy sell and rest. By definition we have:

buy[i]  = max(rest[i-1]-price, buy[i-1]) 
sell[i] = max(buy[i-1]+price, sell[i-1])
rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
Where price is the price of day i. All of these are very straightforward. They simply represents :

(1) We have to `rest` before we `buy` and 
(2) we have to `buy` before we `sell`
One tricky point is how do you make sure you sell before you buy, since from the equations it seems that 
[buy, rest, buy] is entirely possible.

Well, the answer lies within the fact that buy[i] <= rest[i] which means rest[i] = max(sell[i-1], rest[i-1]). 
That made sure [buy, rest, buy] is never occurred.

A further observation is that and rest[i] <= sell[i] is also true therefore

rest[i] = sell[i-1]
Substitute this in to buy[i] we now have 2 functions instead of 3:

buy[i] = max(sell[i-2]-price, buy[i-1])
sell[i] = max(buy[i-1]+price, sell[i-1])
This is better than 3, but

we can do even better

Since states of day i relies only on i-1 and i-2 we can reduce the O(n) space to O(1). And here we are at our 
final solution:*/
