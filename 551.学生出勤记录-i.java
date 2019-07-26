/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */
class Solution {
    public boolean checkRecord(String s) {
        if (s == null || s.length() < 1) {
            return false;
        }
        char[] c = s.toCharArray();
        int ACount = 0;
        int LCount = 0;
        int i = 0;
        while( i < c.length) {
            char cc = c[i];
            if (cc == 'P') {
                LCount = 0;
            } else if(cc == 'A' ) {
                LCount = 0;
                ACount++;
                if (ACount > 1) {
                    return false;
                }
            } else if(cc == 'L') {
                LCount++;
                if(LCount > 2) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}

