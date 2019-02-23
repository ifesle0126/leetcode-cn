/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (36.21%)
 * Total Accepted:    44.2K
 * Total Submissions: 122K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */
class Solution {
    public boolean isValid(String s) {
        char[] chars = new char[s.length()];
        char[] s_chars = s.toCharArray();
        int index = 0;
        for(int i = 0; i < s_chars.length && index >= 0; i++) {
            char c = s_chars[i];
            if (c == '(' || c == '[' || c == '{') {
                chars[index++] = c;
            } else if ( c == ')' && index > 0 &&chars[index - 1] == '(') {
                index = index - 1;
            } else if ( c== ']' && index > 0 && chars[index - 1] == '[') {
                index = index - 1;
            } else if (c == '}' && index > 0 && chars[index - 1] == '{') {
                index = index - 1;
            } else {
                return false;
            }
        }
        return index == 0;
        
    }
}
