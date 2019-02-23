/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 *
 * https://leetcode-cn.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (47.94%)
 * Total Accepted:    20.4K
 * Total Submissions: 42.6K
 * Testcase Example:  '1'
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 
 * 注意：整数顺序将表示为一个字符串。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "1"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 4
 * 输出: "1211"
 * 
 * 
 */
class Solution {
    public String countAndSay(int n) {
        if (n==1) {
            return "1";
        }
        String n1 = "1";
        for (int i = 0; i < n - 1; i++) {
            n1 = descN(n1);
        }
        return n1;

    }

    private String descN(String nStr) {
        String r = "";
        int i = 0;
        int j = i + 1;
        while (i < nStr.length()) {
            if (j >= nStr.length() || nStr.charAt(i) != nStr.charAt(j)) {
                r = r + String.valueOf(j - i) + String.valueOf(nStr.charAt(i));
                i = j;
                j = i + 1;
            } else if (nStr.charAt(i) == nStr.charAt(j)){
                j++;
            }

        }
        return r;
    }
}
