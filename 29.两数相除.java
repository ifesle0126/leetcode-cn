/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 *
 * https://leetcode-cn.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (19.33%)
 * Likes:    283
 * Dislikes: 0
 * Total Accepted:    36.3K
 * Total Submissions: 187.9K
 * Testcase Example:  '10\n3'
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 
 * 示例 1:
 * 
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 
 * 说明:
 * 
 * 
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 * 
 * 
 */

// @lc code=start

class Solution {

    public int divide(int dividend, int divisor) {
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        
        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor))	return 0;
        
        long lans = ldivide(ldividend, ldivisor);
        
        int ans;
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }
    
    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;
        
        //  Find the largest multiple so that (divisor * multiple <= dividend), 
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

    // public int divide(int dividend, int divisor) {
    //     if(dividend == -2147483648 && divisor == -1){
	// 		return 2147483647;
	// 	}
	// 	if(divisor == 1){
	// 		return dividend;
	// 	} else if(divisor == -1){
	// 		return -dividend;
    //     }
    //     int sign = ((dividend>0) ^ (divisor>0)) ? -1:1;
    //     dividend = dividend < 0 ? -dividend : dividend;
    //     divisor = divisor < 0 ? -divisor : divisor;
    //     int r = 0;
    //     while (divisor <= dividend) {
    //         int tmp = 1;
    //         int tmp_divisor = divisor;
    //         while ((tmp_divisor << 1) <= dividend) {
    //             tmp = tmp << 1;
    //             tmp_divisor = tmp_divisor << 1;
    //         }
    //         dividend = dividend - tmp_divisor;
    //         r = r + tmp;
    //     }
    //     return sign == 1 ? r : -r;
    // }   
}
// @lc code=end

