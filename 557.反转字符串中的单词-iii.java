/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */
class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() < 1) {
            return s;
        }
        StringBuilder reverse = new StringBuilder(s).reverse();
        String[] ss = reverse.toString().split(" ");
        int b = 0;
        int e = ss.length -1;
        while (b < e) {
            String tmp = ss[b];
            ss[b] = ss[e];
            ss[e] = tmp;
            b++; e--;
        }
        return String.join(" ", ss);
    }
}

