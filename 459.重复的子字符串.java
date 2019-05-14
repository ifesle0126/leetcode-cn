/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = len/2; i >= 1; i--) {
            if(s.length() % i == 0) {
                String subStr = s.substring(0, i);
                int c = s.length() / i;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < c; j++) {
                    sb.append(subStr);
                }
                if(s.equals(sb.toString())) {
                    return true;
                }
            }
        }
        return false;
    }


}

