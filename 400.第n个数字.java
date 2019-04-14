/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第N个数字
 *
 * https://leetcode-cn.com/problems/nth-digit/description/
 *
 * algorithms
 * Easy (30.97%)
 * Total Accepted:    2.7K
 * Total Submissions: 8.8K
 * Testcase Example:  '3'
 *
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * 
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 2^31)。
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * 3
 * 
 * 输出:
 * 3
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入:
 * 11
 * 
 * 输出:
 * 0
 * 
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 * 
 * 
 */
class Solution {
    public int findNthDigit(int n) {
        long num = n;
        long segment = 9;
        int start = 1;
        int step = 1;
        while (num > segment) {
            num = num - segment;
            step = step * 10;
            start++;
            segment = 9 * step * start;
        }
        // System.out.println("segment: " + segment + " step: " + step + " num: " + num);
        int len = String.valueOf(step).length();
        long count = num / len;
        int i = (int)(num % len);
        return  i == 0 ? String.valueOf(step + count - 1).charAt(len - 1) - '0' 
            : String.valueOf(step + count).charAt(i - 1) - '0';
    }
}

// 1000000000