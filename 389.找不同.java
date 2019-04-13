/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 *
 * https://leetcode-cn.com/problems/find-the-difference/description/
 *
 * algorithms
 * Easy (55.31%)
 * Total Accepted:    7.9K
 * Total Submissions: 14.3K
 * Testcase Example:  '"abcd"\n"abcde"'
 *
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 
 * 请找出在 t 中被添加的字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * 
 * 输出：
 * e
 * 
 * 解释：
 * 'e' 是那个被添加的字母。
 * 
 * 
 */
class Solution {
    public char findTheDifference(String s, String t) {
        int[] alphbet = new int[26];
        for (char c : t.toCharArray()) {
            alphbet[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
                alphbet[c - 'a']--;
        }
        for (int i = 0; i < alphbet.length; i++) {
            if(alphbet[i] > 0) {
                return (char)(i + 'a');
            }
        }
        return ' ';
    }
}

