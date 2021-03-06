/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (31.37%)
 * Total Accepted:    78.4K
 * Total Submissions: 249.8K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 
 */
class Solution {

    public int reverse(int x) {
        int n = x < 0 ? -x : x;
        int sum = 0;
        while (n >= 10) {
            int i = n % 10;
            n = n / 10;
            if ((Integer.MAX_VALUE - i) / 10.0 <= sum) {
                return 0;
            }
            sum = sum * 10 + i;
        }
        if ((Integer.MAX_VALUE - n) / 10.0 <= sum) {
            return 0;
        }
        sum = sum * 10 + n;
        return x < 0 ? -sum : sum;
    }
}
