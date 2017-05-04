
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
/*Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, 
 * the itinerary must begin with JFK.

	Note:
	If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical 
	order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order 
	than ["JFK", "LGB"].
	All airports are represented by three capital letters (IATA code).
	You may assume all tickets form at least one valid itinerary.
	Example 1:
	tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
	Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
	Example 2:
	tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
	Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
	Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.*/

public class Q332_Reconstruct_Itinerary {
	Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }
	/***************************************************************************/
    public List<String> findItinerary_0(String[][] tickets) {
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue<String>()).add(ticket[1]);
        visit("JFK");
        return route;
    }

    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    List<String> route = new LinkedList<String>();

    void visit(String airport) {
        while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
            visit(targets.get(airport).poll());
        route.add(0, airport);
    }
    //interator
    public List<String> findItinerary_1(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue<String>()).add(ticket[1]);
        List<String> route = new LinkedList<String>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }

}
