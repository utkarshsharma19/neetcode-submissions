class Trie{
    Trie [] children;
    boolean isWord;

    public Trie() {
        children = new Trie[26];
        isWord = false;

    }
}
class WordDictionary {
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie curr = root;

        for(char c: word.toCharArray()) {
            int index = c - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new Trie();
            }
            curr = curr.children[index]; 
        }

        curr.isWord = true;
        
    }
    //catch is th at . can be mapped to any character so we have to check all charecaters for it.
    public boolean search(String word) {
       return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, Trie root) {

                if (root == null) {
            return false;
        }

        if (index== word.length()) {
            return root.isWord;
        }
        char c = word.charAt(index);

        if(c == '.') {
            for(Trie child: root.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            } return false;} else {
            int i = c - 'a';
            return dfs(word, index + 1, root.children[i]);
            }
        }
    }
