import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/
public class Q071_Simplify_Path {
	public String simplifyPath(String path) {
		/*这是一道简化路径的题，路径简化的依据是：
		当遇到“/../"则需要返回上级目录，需检查上级目录是否为空。
		当遇到"/./"则表示是本级目录，无需做任何特殊操作。 
		当遇到"//"则表示是本级目录，无需做任何操作。
		当遇到其他字符则表示是文件夹名，无需简化。
		当字符串是空或者遇到”/../”，则需要返回一个"/"。
		当遇见"/a//b"，则需要简化为"/a/b"*/
		/*The main idea is to push to the stack every valid file name (not in {"",".",".."}), popping only if 
		 * there's smth to pop and we met "..". I don't feel like the code below needs any additional comments.*/
		Deque<String> stack = new LinkedList<>();
	    Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
	    for (String dir : path.split("/")) {
	        if (dir.equals("..") && !stack.isEmpty()) stack.pop();
	        else if (!skip.contains(dir)) stack.push(dir);
	    }
	    String res = "";
	    for (String dir : stack) res = "/" + dir + res;
	    return res.isEmpty() ? "/" : res;
    }
	/********************************************************************************/
	public String simplifyPath_0(String path) {
		StringBuilder sb = new StringBuilder("/");
	    LinkedList<String> stack = new LinkedList<String>();
		for(String s: path.split("/")){
			if(s.equals("..")){
			    if(!stack.isEmpty())
				    stack.removeLast();
			}
			else if(!s.equals("") && !s.equals("."))
				stack.add(s);
		}
		for(String s: stack){
			sb.append(s+"/");
		}
		if(!stack.isEmpty()) sb.setLength(sb.length()-1);
		return sb.toString();
	}

}
