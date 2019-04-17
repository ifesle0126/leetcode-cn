/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 *
 * https://leetcode-cn.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (44.43%)
 * Total Accepted:    6.3K
 * Total Submissions: 14.1K
 * Testcase Example:  '"0"\n"0"'
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 
 * 注意：
 * 
 * 
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * 
 * 
 */
class Solution {
    public String addStrings(String num1, String num2) {
        String r = "";
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int step = 0;
        while (len1 >= 0 && len2 >= 0) {
            int n1 = num1.charAt(len1) - '0';
            int n2 = num2.charAt(len2) - '0';
            int num = n1 + n2 + step;
            step = num / 10;
            num = num % 10;
            r = num + r;
            len1--;
            len2--;
        }
        while (len1 >= 0){
            if (step == 0) {
                r = num1.substring(0, len1 + 1) + r;
                break;
            } else {
                int num = num1.charAt(len1) - '0';
                num = num + step;
                step = num / 10;
                num = num % 10;
                r = num + r;
            }
            len1--;
        }
        while (len2 >= 0){
            if (step == 0) {
                r = num2.substring(0, len2 + 1) + r;
                break;
            } else {
                int num = num2.charAt(len2) - '0';
                num = num + step;
                step = num / 10;
                num = num % 10;
                r = num + r;
            }
            len2--;
        }
        if (step != 0) {
            r = step + r;
        }
        return r;
    }
}

