import java.util.ArrayDeque;
import java.util.Deque;

public class Q388_Longest_Absolute_File_PathQ {
	/*利用栈（Stack）数据结构。

	首先将字符串以'\n'进行分割，得到目录/文件的列表，记为parts
	
	然后统计各目录/文件中'\t'的个数，表示当前目录/文件的深度
	
	遍历parts，若栈顶元素的深度不小于parts的深度，则弹出栈顶元素，重复此过程。
	
	然后将新的深度压入栈中，顺便统计当前目录的总长度。
	可以借助一个栈来保存当前层的路径, 层数可以利用tab字符的个数来确定, 如果当前行的层数大于栈顶元素并且非文件, 就可以让其进入栈, 
	否则如果当前行是文件就可以比较大小, 或者如果当前行是目录但是深度小于等于栈顶元素, 就可以将栈顶元素出栈, 直到为空或者小于当前行的深度.*/
	public int lengthLongestPath(String input) {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0); // "dummy" length 虚假长度
		int maxLen = 0;
		for(String s:input.split("\n")){
			int lev = s.lastIndexOf("\t")+1; //number of "\t" depth of current 
			while(lev+1<stack.size()) stack.pop(); //find parent
			int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
			stack.push(len);
			//check if it is file
			if(s.contains(".")) maxLen = Math.max(maxLen, len-1);
		}
		return maxLen;
	}
	public int lengthLongestPath_0(String input) {
		String[] paths = input.split("\n");
		int[] stack = new int[paths.length+1];
		int maxLen = 0;
		for(String s:paths) {
			int lev = s.lastIndexOf("\t")+1, curLen = stack[lev+1] = stack[lev]+s.length()-lev+1;
			if(s.contains(".")) maxLen = Math.max(maxLen, curLen-1);
		}
		return maxLen;
	}
	/*这道题给了我们一个字符串，里面包含\n和\t这种表示回车和空格的特殊字符，让我们找到某一个最长的绝对文件路径，要注意的是，最长绝对文件路径不一
	 * 定是要最深的路径，我们可以用哈希表来建立深度和当前深度的绝对路径长度之间的映射，那么当前深度下的文件的绝对路径就是文件名长度加上哈希表中
	 * 当前深度对应的长度，我们的思路是遍历整个字符串，遇到\n或者\t就停下来，然后我们判断，如果遇到的是回车，我们把这段文件名提取出来，如果里
	 * 面包含'.'，说明是文件，我们更新res长度，如果不包含点，说明是文件夹，我们深度level自增1，然后建立当前深度和总长度之间的映射，然后我们将
	 * 深度level重置为0。之前如果遇到的是空格\t，那么我们深度加一，通过累加\t的个数，我们可以得知当前文件或文件夹的深度，然后做对应的处理，
	 * 参见代码如下*/
	
}
