/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 *
 * https://leetcode-cn.com/problems/word-search/description/
 *
 * algorithms
 * Medium (40.97%)
 * Likes:    344
 * Dislikes: 0
 * Total Accepted:    45.1K
 * Total Submissions: 110.1K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 
 * 
 * 示例:
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] record = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean f = backtrack(board, i, j, word, 0, record, -1 , -1);
                if(f) {
                    return f;
                }
            }
        }
        return false;

    }

    // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"
    // [["a","a","a","a"],["a","a","a","a"],["a","a","a","a"]]\n"aaaaaaaaaaaaa"
    public boolean backtrack(char[][] board, int i ,int j, String word, int c, boolean[][] record, int beforeI, int beforeJ) {
        if(i < 0 || i >= board.length) {
            return false;
        }
        if(j < 0 || j >= board[i].length) {
            return false;
        }
        if(record[i][j]) {
            return false;
        }
        if(board[i][j] != word.charAt(c)) {
            return false;
        } else {
            if(c == word.length() -1) {
                return true;
            } else {
                record[i][j] = true;
                boolean r = (beforeI == i + 1 && beforeJ == j ? false : backtrack(board, i + 1, j, word, c + 1, record, i, j))
                    || (beforeI == i && beforeJ == j + 1 ? false : backtrack(board, i, j + 1, word, c + 1, record, i, j))
                    || (beforeI == i - 1 && beforeJ == j ? false : backtrack(board, i - 1, j, word, c + 1, record, i, j))
                    || (beforeI == i && beforeJ == j - 1 ? false : backtrack(board, i, j - 1, word, c + 1, record, i, j));
                if(r) {
                    return true;
                } else {
                    record[i][j] = false;
                    return false;
                }
            }
        }
    }
}
// @lc code=end

