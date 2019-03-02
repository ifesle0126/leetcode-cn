/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (37.49%)
 * Total Accepted:    37.6K
 * Total Submissions: 100.2K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int[] plus = new int[digits.length];
        int step = 1;
        int index = digits.length - 1;
        do {
            int d = digits[index];
            if(step == 1) {
                d = d + step;   
            }
            step = d / 10;
            d = d % 10;
            plus[index] = d;
            index--;
        } while(index >= 0);

        if(digits[0]==9 && step == 1) {
            int[] tmp = new int[plus.length + 1];
            tmp[0] = step;
            for (int i = 1; i < tmp.length; i++) {
                tmp[i] = plus[i-1];
            }
            plus = tmp;
        }
      
        return plus;
    }
}
