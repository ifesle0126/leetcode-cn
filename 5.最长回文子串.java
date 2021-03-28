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

        char[] chars = s.toCharArray();
        int[][] table = new int[s.length()][s.length()];
        int max = 0;
        int ii = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1 - i; j >= 0 ; j--) {
                if (chars[i] == chars[j]) {
                    if(i - 1 >= 0 && j - 1 >=0) {
                        table[i][j] = table[i - 1][j - 1] + 1;
                    } else {
                        table[i][j] = 1;
                    }
                    if (table[i][j] >= max) {
                        ii = i;
                        max = table[i][j];
                        System.out.println(ii + " " + max);
                    }
                }
            }
        }

        String r = "";

        while (max > 0) {
            r = r + chars[ii--];
            max--;
        }
        return r;

    }


    public String longestPalindrome2(String s) {
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
            while(j > b && j >= 0) {
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
                }
            }
            if(j <= b && m_s[j] == m_s[b]) {
                String tmp = s.substring(i, i + len + 1);
                if(r.length() < tmp.length()) {
                    r = tmp;
                }
            }
        }
        return "".equals(r) ? m_s[0] + "" : r;
    }
}
// @lc code=end

