public class WordDictionary {
    private TrieNode root;
    // initialize 
    public WordDictionary(){
        this.root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            node = node.addChildren(word.charAt(i));
        }
        node.setIsWord();
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root, 0);
    }
    // Depth first search 
    // index == "." ,from start to check if the next trienode is valid
    private boolean search(String word, TrieNode root, int index){
        if(index == word.length()){
            return root.isWord();
        }
        if(word.charAt(index) == '.'){
            for(TrieNode child : root.getAllChildren()){
                if(search(word, child, index + 1)){
                    return true;
                }
            }
        }else{
            TrieNode node = root.getOneChild(word.charAt(index));
            if(node != null){
                return search(word, node, index + 1);
            }
        }
        return false;
    }
}

 class TrieNode {
     
    private Map<Character, TrieNode> children;
    private boolean isWord;
    
    public TrieNode(){
        this.children = new HashMap<Character, TrieNode>();
    }
    
    void setIsWord(){
        isWord = true;
    }
    
    boolean isWord(){
        return isWord;
    }
    // add children in if it is not in the trie
    TrieNode addChildren(Character c){
        if(!children.containsKey(c)){
            children.put(c, new TrieNode());
        }
        return children.get(c);
    }
    
    TrieNode getOneChild(Character c){
        return children.get(c);
    }
    
    List<TrieNode> getAllChildren(){
        return new ArrayList<TrieNode>(children.values());
    }
    
    
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");