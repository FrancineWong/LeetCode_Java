import java.util.ArrayList;
import java.util.List;

/*Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/
public class Q118_Pascals_Triangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> tr = new ArrayList<List<Integer>>();

		if(numRows==0) {
			return tr;
		}
		
		for(int i=1; i<=numRows; i++){
			List<Integer> row = new ArrayList<Integer>(i);
			for(int j=0; j<i; j++){
				if(j==0) row.add(1);
				else if(j==i-1) row.add(1);
				else row.add(tr.get(i-2).get(j-1)+tr.get(i-2).get(j));
			}
			tr.add(row);
		}
		return tr;
    }
}
