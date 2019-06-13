/*
 * @lc app=leetcode.cn id=476 lang=java
 *
 * [476] 数字的补数
 */
class Solution {
    public int findComplement(int num) {
        if(num == 0) {
            return 1;
        }
        int step = 1;
        int result = 0;
        while (num != 0) {
            if(num % 2 != 1) {
                result = result + step;
            }
            step = step * 2;
            num = num / 2;
        }
        return result;
    }
}

