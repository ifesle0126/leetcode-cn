/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (31.59%)
 * Total Accepted:    48.4K
 * Total Submissions: 153.3K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String r = "";
        if (strs == null || strs.length < 1) {
            return r;
        }
        if (strs.length == 1) {
            return strs[0];
        }
        char[] subChar = new char[strs.length];
        for (int j = 0; ;j++) {
            for(int i = 0; i < strs.length; i++) {
                String str = strs[i];
                if(str.length() <= j) {
                    return r;
                }
                subChar[i] = str.charAt(j);
                if (i != 0 && subChar[i] != subChar[i - 1]) {
                    return r;
                }
            }
            r = r + strs[0].charAt(j);
        }
    }
}
