import sun.net.www.content.text.plain;

/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (38.36%)
 * Total Accepted:    26.6K
 * Total Submissions: 69.2K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "race a car"
 * 输出: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() < 1) {
            return true;
        }
        char[] charArray = s.toCharArray();
        int b = 0;
        int e = charArray.length - 1;
        while (b < e) {
            char b_c = charArray[b];
            char e_c = charArray[e];
            if (!validate(b_c)) {
                b++;
            } else if (!validate(e_c)) {
                e--;
            } else {
                if (b_c >= 97 && b_c <= 122) {
                    b_c = (char)(b_c - 32);
                }
                if (e_c >= 97 && e_c <= 122) {
                    e_c = (char)(e_c - 32);
                }
                if (b_c != e_c) {
                    return false;
                }
                b++;e--;
            }
        }
        return true;
    }

    private boolean validate(char c) {
        if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <=122)) {
            return true;
        }
        return false;
    }
}

