/*Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.*/
class TrieNode{
	public char val;
	public boolean isWord;
	public TrieNode[] children = new TrieNode[26];
	public TrieNode() {};
	TrieNode(char c) {
		TrieNode node = new TrieNode();
		node.val = c;
	}
}
public class Q208_Implement_Trie_Prefix_Tree {
	private TrieNode root;
	/*Initialize your data structure here*/
    public Q208_Implement_Trie_Prefix_Tree() {
        root = new TrieNode();
        root.val = ' ';
    }

    /*Insert a word into the trie*/
    public void insert(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /*Return if a word is in the trie*/
    public boolean search(String word) {
        TrieNode ws = root; 
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    /*return if any word in the trie starts with prefix*/
    public boolean startsWith(String prefix) {
        TrieNode ws = root; 
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}


