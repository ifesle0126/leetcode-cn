/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 *
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (60.34%)
 * Total Accepted:    17.6K
 * Total Submissions: 29.2K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 5
 * 输出:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 */
import java.util.*;


class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(Arrays.asList(1));
        for(int i = 1; i < numRows; i++) {
            List<Integer> line = new ArrayList<>(i + 1);
            line.add(1);
            for(int j = 1; j < i; j++) {
                List<Integer> preLine = result.get(i - 1);
                int preJ = j - 1< 0 ? 0 : j - 1;
                int sufJ = preJ + 1;
                int item = preLine.get(preJ) + preLine.get(sufJ);
                line.add(item);
            }
            line.add(1);
            result.add(line);
        }
        return result;
    }
}

