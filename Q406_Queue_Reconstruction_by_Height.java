import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q406_Queue_Reconstruction_by_Height {
	/*Pick out tallest group of people and sort them in a subarray (S). Since there's no other groups of 
	 * people taller than them, therefore each guy's index will be just as same as his k value.
	For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.
	E.g.
	input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	subarray after step 1: [[7,0], [7,1]]
	subarray after step 2: [[7,0], [6,1], [7,1]]
	...*/
	public int[][] reconstructQueue(int[][] people) {
		//pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        Arrays.sort(people,new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
           }
        });
        List<int[]> res = new ArrayList<int[]>();
        for(int[] cur : people){
        	if (cur[1] >= res.size())
        		res.add(cur);
        	else
        		res.add(cur[1],cur);    //add(index, element)   
        }
        return res.toArray(new int[people.length][]);
    }
}
