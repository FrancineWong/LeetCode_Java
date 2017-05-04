import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest 
 * transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please 
reload the code definition to get the latest changes.*/
public class Q127_Word_Ladder {
	/*i think the intuition is that you are replacing a big search tree in the one-end solution with two 
	 * smaller trees in the two-end solution. Both solutions have the same TOTAL depth, yet tree width 
	 * grows exponentially w.r.t. depths, and the two-end solutions results in less nodes being visited.*/
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

		int len = 1;
		int strLen = beginWord.length();
		HashSet<String> visited = new HashSet<String>();
		
		beginSet.add(beginWord);
		endSet.add(endWord);
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}

			Set<String> temp = new HashSet<String>();
			for (String word : beginSet) {
				char[] chs = word.toCharArray();

				for (int i = 0; i < chs.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char old = chs[i];
						chs[i] = c;
						String target = String.valueOf(chs);

						if (endSet.contains(target)) {
							return len + 1;
						}

						if (!visited.contains(target) && wordList.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
						chs[i] = old;
					}
				}
			}

			beginSet = temp;
			len++;
		}
		
		return 0;
    }
	/*************************************  Dijkstra's algorithm  *******************************************/
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        wordDict.add(endWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }
	/*Basically I keep two sets of words, one set reached that represents the borders that have been reached 
	 * with "distance" steps; another set wordDict that has not been reached. In the while loop, for each 
	 * word in the reached set, I give all variations and check if it matches anything from wordDict, 
	 * if it has a match, I add that word into toAdd set, which will be my "reached" set in the next loop, 
	 * and remove the word from wordDict because I already reached it in this step. And at the end of 
	 * while loop, I check the size of toAdd, which means that if I can't reach any new String from wordDict,
	 *  I won't be able to reach the endWord, then just return 0. Finally if the endWord is in reached set, 
	 *  I return the current steps "distance".

	The idea is that reached always contain only the ones we just reached in the last step, and wordDict always 
	contain the ones that haven't been reached. This is pretty much what Dijkstra's algorithm does, or you can 
	see this as some variation of BFS.
	
	ps: I get TLE at the first two submissions, because when I check if wordDict has any matches with reached 
	set, I use two for loops and determine if any pair of words differ by one. That's a huge slow-down because 
	it'll takes m (size of reached) * n (size of wordDict) * l (length of words) time, while in this solution, 
	it takes 26 * l * m time. So when n is huge, this solution will be (n/26) times faster.*/
}
