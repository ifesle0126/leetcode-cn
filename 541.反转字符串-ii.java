/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */
class Solution {
    public String reverseStr(String s, int k) {
        int index = 0;
        String r = "";
        while (index < s.length()) {
            int end = index + k < s.length() ? index + k : s.length();
            String sub = s.substring(index, end);
            if(index / k % 2 != 1) {
                sub = new StringBuilder(sub).reverse().toString();
            }
            r += sub;
            index = index + k;
        }
        return r;
    }
}

