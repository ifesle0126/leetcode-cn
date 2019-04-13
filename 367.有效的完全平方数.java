/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 *
 * https://leetcode-cn.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (40.18%)
 * Total Accepted:    8K
 * Total Submissions: 19.9K
 * Testcase Example:  '16'
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * 
 * 示例 1：
 * 
 * 输入：16
 * 输出：True
 * 
 * 示例 2：
 * 
 * 输入：14
 * 输出：False
 * 
 * 
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        long r = num;
        while (r * r > num) {
            r = (r + num/r) / 2;
        }
        return r * r == num;
    }
}

