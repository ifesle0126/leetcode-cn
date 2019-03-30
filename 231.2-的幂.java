/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 *
 * https://leetcode-cn.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (44.55%)
 * Total Accepted:    14.9K
 * Total Submissions: 33.5K
 * Testcase Example:  '1'
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * 
 * 示例 2:
 * 
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * 
 * 示例 3:
 * 
 * 输入: 218
 * 输出: false
 * 
 */
class Solution {

    public boolean isPowerOfTwo(int n) {
        return n >= 0 && Integer.bitCount(n) == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        if(n <= 0) {
            return false;
        }
        int c = 0;
        while(n > 0) {
            c += n%2;
            if (c > 1) {
                return false;
            }
            n = n /2;
        }
        return true;
    }
}

