/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 *
 * https://leetcode-cn.com/problems/sum-of-two-integers/description/
 *
 * algorithms
 * Easy (53.22%)
 * Total Accepted:    9K
 * Total Submissions: 16.8K
 * Testcase Example:  '1\n2'
 *
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * 
 * 示例 1:
 * 
 * 输入: a = 1, b = 2
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: a = -2, b = 3
 * 输出: 1
 * 
 */
class Solution {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
    
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        
        return a;
    }
}

