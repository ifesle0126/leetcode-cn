/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (66.79%)
 * Likes:    280
 * Dislikes: 0
 * Total Accepted:    34.7K
 * Total Submissions: 51.9K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");   
 * trie.search("app");     // 返回 true
 * 
 * 说明:
 * 
 * 
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 
 * 
 */

// @lc code=start
class Trie {

    TrieNode root = null;

    class TrieNode {
        char c;
        TrieNode[] nodes = null;
        boolean isEnd = false;

        public TrieNode() {
            c = ' ';
            nodes = new TrieNode[26];
        }

        public TrieNode(char c) {
            this.nodes = new TrieNode[26];
            this.isEnd = false;
            this.c = c;
        }

        public void putChild(char cc) {
            nodes[cc - 'a'] = new TrieNode(cc);
        }

        public TrieNode getChildNode(char cc) {
            return nodes[cc - 'a'];
        }

        public boolean containChild(char cc) {
            return nodes[cc - 'a'] != null;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char cc = word.charAt(i);
            if(!node.containChild(cc)) {
                node.putChild(cc);
            }
            node = node.getChildNode(cc);
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char cc = word.charAt(i);
            if (!node.containChild(cc)) {
                return false;
            }
            node = node.getChildNode(cc);
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char cc = prefix.charAt(i);
            if (!node.containChild(cc)) {
                return false;
            }
            node = node.getChildNode(cc);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

