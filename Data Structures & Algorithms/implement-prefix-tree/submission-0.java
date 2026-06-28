class Trie{
    Trie[] children;
    boolean isWord;
    public Trie() {
        children = new Trie[26];
        isWord = false;
    }
}
class PrefixTree {
    Trie root;
    public PrefixTree() {
         root = new Trie();
    }

    public void insert(String word) {
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

    public boolean search(String word) {
               Trie curr = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie curr = root;
        for(char c: prefix.toCharArray()) {
            int index = c - 'a';
            if(curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }

        return true;
    }
}
