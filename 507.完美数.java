/*
 * @lc app=leetcode.cn id=507 lang=java
 *
 * [507] 完美数
 */
class Solution {

    public boolean checkPerfectNumber(int num) {
        if(num <= 1) {
            return false;
        }
        int num_temp = 1;
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                num_temp= num_temp + i + (num/i);
            }
        }
        return num_temp == num?true:false;
    }


    /**
     * time limit 
     * @param num
     * @return
     */
    public boolean checkPerfectNumber_ERROR(int num) {
        if(num <= 1) {
            return false;
        }
        int num_temp = 0;
        for (int i = num - 1; num_temp < num && i > 0; i--) {
            if (num % i == 0) {
                if(i!=num) {
                    num_temp+=i;
                }
                int t = num_temp/i;
                if(t != num) {
                    num_temp+=t;
                }
            }
        }
        return num_temp == num ? true : false;
    }
}

