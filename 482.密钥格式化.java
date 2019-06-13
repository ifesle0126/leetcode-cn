import java.util.*;
import java.util.stream.*;

/*
 * @lc app=leetcode.cn id=482 lang=java
 *
 * [482] 密钥格式化
 */
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        S = String.join("", S.split("-"));
        int n = S.length();
        StringBuilder sb = new StringBuilder();
        
        for (int i = n - K; ; i -= K) {
            if (i > 0) {
                sb.insert(0, "-" + S.substring(i, i + K));
            }
            else {
                //substring before the first '-' from left
                sb.insert(0, S.substring(0, i + K));
                break;
            }
        }
        return sb.toString();
    }
}

