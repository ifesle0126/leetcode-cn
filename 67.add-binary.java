/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (46.58%)
 * Total Accepted:    16.7K
 * Total Submissions: 35.9K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() < 1) {
            return b;
        }
        if(b ==null || b.length() < 1) {
            return a;
        }
        String result = "";
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int i_a = aChar.length - 1;
        int i_b = bChar.length - 1;
        int step = 0;
        int i = 0;
        while(i_a - i >= 0 || i_b - i >= 0) {
            int n_a = i_a - i >= 0 ? aChar[i_a - i] - 48 : 0;
            int n_b = i_b - i >= 0 ? bChar[i_b - i] - 48 : 0;
            int n = n_a + n_b + step;
            step = n / 2;
            int nn = n % 2;
            result = ((char)(nn + 48)) + result;
            i++;
        }
        if(step == 1) {
            result = ((char)(step + 48)) + result;
        }
        return result;
        
    }

    // '"1010"\n"1011"'
}
