/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (34.57%)
 * Total Accepted:    23.9K
 * Total Submissions: 69K
 * Testcase Example:  '4'
 *
 * 实现 int sqrt(int x) 函数。
 * 
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * 示例 1:
 * 
 * 输入: 4
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 * 由于返回类型是整数，小数部分将被舍去。
 * 
 * 
 */
class Solution {

    /**
     * 牛顿迭代法
     * 
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        double  i = 0;
        double  j = 1;
        while (i != j) {
            i = j;
            j = (j + x / j) / 2;
        }
        return (int)j;
        
    }

    /**
     * 二分查找法
     * 
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        int i = 1;
        int j = x/2 + 1;
        while (i <= j) {
            int m = (i + j) / 2;
            int s = m * m;
            if (s == x) {
                return m;
            } else if (s < x) {
                i = m + 1;
            } else if (s > x) {
                j = m - 1;
            }
        }
        return j;
        
    }
}
