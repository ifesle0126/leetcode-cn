/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (34.01%)
 * Likes:    271
 * Dislikes: 0
 * Total Accepted:    54.5K
 * Total Submissions: 160.1K
 * Testcase Example:  '2.00000\n10'
 * 
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 
 * 
 * 示例 2:
 * 
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 
 * 
 * 示例 3:
 * 
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 说明:
 * 
 * 
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 * 
 * 
 */

// @lc code=start


class Solution {
    public double myPow(double x, int n) {
        if(n == 0 || x == 1) {
            return 1.0;
        }
        if(x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }
        if(n == -2147483648) {
            return 0.0;
        }
        if(n < 0){
            n = -n;
            x = 1/x;
        }

        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}

class Solution2 {
    public double myPow(double x, int n) {
        if(x == 0) {
            return 0;
        }
        if(n == 0 || x == 1D) {
            return 1;
        }
        boolean f = true;
        if(n < 0) {
            f = false;
            n = -n;
        }
        double sum = 1;
        while (n > 0) {
            sum = sum * x;
            n--;
        }
        return f ? sum : 1 / sum;
    }
}
// @lc code=end

