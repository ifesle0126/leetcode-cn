/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int c  = 0;
        while (x > 0 && y > 0) {
            if (x % 2 != y % 2) {
                c++;
            }
            x = x / 2; y = y / 2;
        }
        int t = x == 0? y : x;
        while (t > 0) {
            if (t % 2 == 1) {
                c++;
            }
            t = t / 2;
        }
        return c;
    }
}

