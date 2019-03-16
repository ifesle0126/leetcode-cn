/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (54.13%)
 * Total Accepted:    10.9K
 * Total Submissions: 20.2K
 * Testcase Example:  '3'
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: [1,3,3,1]
 * 
 * 
 * 进阶：
 * 
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 
 */
import java.util.*;


class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if (rowIndex == 0) {
            return result;
        }
        for(int i = 1; i <= rowIndex; i++) {
            // 二项式系数
            long l = result.get(i - 1).longValue() * (rowIndex + 1 - i) / i;
            result.add((int)l);
        }
        return result;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            result.add(getN(i, rowIndex).intValue());
        }
        return result;
    }

    private Long getN(int m, int n) {
        if(m == 0 || n == m) {
            return 1L;
        }
        if (m == 1 || m - m == 1) {
            return new Long(n);
        }
        /*
        return n!/((n-m)! * m!)
        */
        long sumM = 1;
        long sumN = 1;
        for(int iN = n, iM = m; iN > n - m && iM>=1; iN--, iM--) {
            sumN *= iN;
            if (sumN % iM == 0) {
                sumN = sumN / iM;
                continue;
            }
            sumM *= iM;
            if (sumN % sumM == 0) {
                sumN = sumN / sumM;
                sumM = 1;
            }
            
        }
        return sumN/sumM;
    }


}

