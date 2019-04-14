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
        // digit表示要找的个位数“所属的”多位数x的位数
        // t表示该多位数一共有多少个
        // digit=1 t=9  表示1~9    中全是1位数，共有9个
        // digit=2 t=90 表示10~99  中全是2位数，共有90个
        // digit=3 t=900表示100~999中全是3位数，共有900个
        int digit = 1;
        Long t = 9L;
        
        // 找到n所求的数“所属的”多位数x的范围
        while (n - t * digit > 0) {
            n = (int) (n - t * digit);
            t = t * 10;
            digit++;
        }
        
        // 此时应从位数为digit的数字里面找第n个，即为所求值
        // basevalue是第一个被找的数字，比如1,10,100,1000...
        // no_basevalue是x的值
        int basevalue = (int) Math.pow(10, digit-1);
        int no_basevalue = (n - 1) / digit;
        basevalue += no_basevalue;
        // 找到所求的“个位数”在x中的下标，返回
        // 此时n的意义是：在所有digit位数连接成的字符串中所求数的下标位置+1
        // 下标位置+1，所以要n-1
        // 所有digit位数的字符串中的下标，所以对digit取余数
        char c = String.valueOf(basevalue).toCharArray()[(n - 1) % digit];
        return Integer.parseInt("" + c);
    }

    
    // 1000000000 time limit exception
    public int findNthDigit2(int n) {
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
