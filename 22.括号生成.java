/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (73.57%)
 * Likes:    799
 * Dislikes: 0
 * Total Accepted:    85.8K
 * Total Submissions: 116.7K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */
import java.util.*;


// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<>();
        if(n < 1) {
            return r;
        }
        if(n == 1) {
            r.add("()");
            return r;
        }
        backtrack(r, "", 0, 0, n);
        return r;
    }

    private void backtrack(List<String> list, String str, int left , int right, int max) {
        if(str.length() == max * 2) {
            list.add(str);
            return;
        }
        if(left < max) {
            backtrack(list, str + "(", left + 1, right, max);
        } 
        if (right < left) {
            backtrack(list, str + ")", left, right + 1, max);
        }
    }
}
// @lc code=end

