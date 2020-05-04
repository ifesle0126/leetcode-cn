/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 *
 * https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/description/
 *
 * algorithms
 * Medium (44.25%)
 * Likes:    115
 * Dislikes: 0
 * Total Accepted:    10.2K
 * Total Submissions: 23.1K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n' +
  '[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * 设计一个支持以下两种操作的数据结构：
 * 
 * void addWord(word)
 * bool search(word)
 * 
 * 
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * 
 * 示例:
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * 
 * 说明:
 * 
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 * 
 */

// @lc code=start
import java.util.*;

class WordDictionary {
    Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
    // Adds a word into the data structure.
    public void addWord(String word) {
        int index = word.length();
        if(!map.containsKey(index)){
            List<String> list = new ArrayList<String>();
            list.add(word);
            map.put(index, list);
        }else{
            map.get(index).add(word);
        }
        
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        int index = word.length();
        if(!map.containsKey(index)){
            return false;
        }
        List<String> list = map.get(index);
        if(isWords(word)){
            return list.contains(word);
        }
        for(String s : list){
            if(isSame(s, word)){
                return true;
            }
        }
        return false;
    }
    
    boolean isWords(String s){
        for(int i = 0; i < s.length(); i++){
            if(!Character.isLetter(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    boolean isSame(String a, String search){
        if(a.length() != search.length()){
            return false;
        }
        for(int i = 0; i < a.length(); i++){
            if(search.charAt(i) != '.' && search.charAt(i) != a.charAt(i)){
                return false;
            }
        }
        return true;
    }

}


// class WordDictionary {

//     Node root;

//     class Node {
//         Node[] nodes;
//         boolean isEnd;
//         char c;

//         public Node() {
//             this.nodes = new Node[26];
//             this.isEnd = false;
//             this.c = ' ';
//         }

//         public Node(char cc) {
//             this.nodes = new Node[26];
//             this.isEnd = false;
//             this.c = cc;
//         }

//         public void addChild(char cc) {
//             nodes[cc - 'a'] = new Node(cc);
//         }

//         public boolean hasChild(char cc) {
//             return nodes[cc - 'a'] != null;
//         }

//         public Node getChild(char cc) {
//             return nodes[cc - 'a'];
//         }

//         public Node[] getChildren() {
//             return nodes;
//         }
//     }

//     /** Initialize your data structure here. */
//     public WordDictionary() {
//         this.root = new Node();
//     }
    
//     /** Adds a word into the data structure. */
//     public void addWord(String word) {
//         if(".".equals(word)) {
//             return;
//         }
//         Node node = root;
//         for (int i = 0; i < word.length(); i++) {
//             char cc = word.charAt(i);
//             if (!node.hasChild(cc)) {
//                 node.addChild(cc);
//             }
//             node = node.getChild(cc);
//         }
//         node.isEnd = true;
//     }
    
//     /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
//     public boolean search(String word) {
//         Node node = root;
//         for(int i = 0; i < word.length(); i++) {
//             char cc = word.charAt(i);
//             if(cc == '.') {
//                 if (i == 0) {
//                     boolean f = false;
//                     for (Node nodeSub : node.getChildren()) {
//                         if (nodeSub == null) {
//                             continue;
//                         }
//                         f = f || search(word, nodeSub.getChildren());
//                     }
//                     return f;
//                 } else {
//                     return search(word.substring(i + 1), node.getChildren());
//                 }
//             } else if (!node.hasChild(cc)) {
//                 return false;
//             }
//             node = node.getChild(cc);
//         }
//         return node.isEnd;
//     }

//     private boolean search(String word, Node[] nodes) {
        
//         boolean hasNext = ".".equals(word);
//         for (Node node : nodes) {
//             if (node != null) {
//                 hasNext = true;
//                 break;
//             }
//         }
//         if(!hasNext) {
//             return false;
//         }
//         for(int i = 0; i < nodes.length; i++) {
//             Node node = nodes[i];
//             if(node == null) {
//                 continue;
//             }
//             for (int j = 0; j < word.length(); j++) {
//                 char cc = word.charAt(j);
//                 if (cc == '.') {
//                     return search(word.substring(j + 1), node.getChildren());
//                 } else if (!node.hasChild(cc)) {
//                     break;
//                 }
//                 node = node.getChild(cc);
//             }
//             return node.isEnd;
//         }
//         return false;
//     }
// }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

