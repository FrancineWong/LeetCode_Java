import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/*/
public class Q133_Clone_Graph {
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
	//my wrong answer
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode root = null;
        if(node == null) return null;
        while(node!=null) {
        	root = new UndirectedGraphNode(node.label);
        	root.neighbors = new ArrayList<UndirectedGraphNode>();
        	for(UndirectedGraphNode e:node.neighbors) {
        		root.neighbors.add(e);
        		cloneGraph(e);
        	}
        }
        return root;
    }
	/***********************************************************/
	//by putting this line map.put(clone.label, clone); before for loop makes sure cycle can be detected.
	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph_0(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;
        
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
}