/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 *
 * https://leetcode-cn.com/problems/base-7/description/
 *
 * algorithms
 * Easy (45.10%)
 * Likes:    16
 * Dislikes: 0
 * Total Accepted:    4.1K
 * Total Submissions: 9.1K
 * Testcase Example:  '100'
 *
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 100
 * 输出: "202"
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: -7
 * 输出: "-10"
 * 
 * 
 * 注意: 输入范围是 [-1e7, 1e7] 。
 * 
 */
class Solution {
    public String convertToBase7(int num) {
        if(num == 0) {
            return "0";
        }
        boolean f = true;
        if(num < 0) {
            f = false;
        }
        String r = "";
        while (num != 0) {
            int n = num % 7;
            n = n < 0 ? -n : n;
            r = n + r;
            num  = num / 7;
        }
        return f ? r : "-" + r;
    }
}

