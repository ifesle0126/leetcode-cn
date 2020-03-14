/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (28.88%)
 * Likes:    1852
 * Dislikes: 0
 * Total Accepted:    203.6K
 * Total Submissions: 705K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        char[] m_s = s.toCharArray();
        String r = "";
        for(int i = 0; i < m_s.length; i++) {
            int b = i;
            int j = m_s.length - 1;
            int step = 0;
            int len = 0;
            while(j >= b && j >= 0) {
                if(m_s[b] == m_s[j]) {
                    int l = j - b;
                    if(l > len) {
                        len = l;
                    }
                    b++;
                    j--;
                } else {
                    step++;
                    j = m_s.length - 1 - step;
                    b = i;
                    len = 0;
                    continue;
                }
            }
            if(j < b) {
                String tmp = s.substring(i, i + len + 1);
                if(tmp.length() > r.length()) {
                    r = tmp;
                }
            }

        }
        return r;
    }
}
// @lc code=end

