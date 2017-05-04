import java.util.ArrayList;
import java.util.List;

public class Q536_Construct_Binary_Tree_from_StringQ {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode str2tree(String s) {
        if(s.length()==0||s==null) return null;
        int count = 0;
        int num = 0, start = 0;
        TreeNode root = null;
        boolean isNegative = false;
        if(!s.contains("(")) root = new TreeNode(Integer.valueOf(s));
        List<String> children = new ArrayList<String>();
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if(c=='(') {
        		if(count++ == 0) {
        			start = i;
        			if(children.isEmpty()) 
        				root = new TreeNode(isNegative?-num:num);
        		}
        	}
        	else if (c==')') {
        		if(--count==0) 
        			children.add(s.substring(start+1, i));
        	}
        	else if(c=='-')
        		isNegative = true;
        	else if(count==0) 
        		num = num*10+c-'0';
        }
        if(children.size()>0) root.left = str2tree(children.get(0));
        if(children.size()>1) root.right = str2tree(children.get(1));
        return root;
    }
	
}
