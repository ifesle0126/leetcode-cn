import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 *
 * https://leetcode-cn.com/problems/excel-sheet-column-number/description/
 *
 * algorithms
 * Easy (63.21%)
 * Total Accepted:    10.3K
 * Total Submissions: 16.3K
 * Testcase Example:  '"A"'
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 
 * 例如，
 * 
 * ⁠   A -> 1
 * ⁠   B -> 2
 * ⁠   C -> 3
 * ⁠   ...
 * ⁠   Z -> 26
 * ⁠   AA -> 27
 * ⁠   AB -> 28 
 * ⁠   ...
 * 
 * 
 * 示例 1:
 * 
 * 输入: "A"
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入: "AB"
 * 输出: 28
 * 
 * 
 * 示例 3:
 * 
 * 输入: "ZY"
 * 输出: 701
 * 
 * 致谢：
 * 特别感谢 @ts 添加此问题并创建所有测试用例。
 * 
 */
import java.util.*;


class Solution {

    private Map<String, Integer> char2Int = new HashMap(){{
        put("A", 1);
        put("B", 2);
        put("C", 3);
        put("D", 4);
        put("E", 5);
        put("F", 6);
        put("G", 7);
        put("H", 8);
        put("I", 9);
        put("J", 10);
        put("K", 11);
        put("L", 12);
        put("M", 13);
        put("N", 14);
        put("O", 15);
        put("P", 16);
        put("Q", 17);
        put("R", 18);
        put("S", 19);
        put("T", 20);
        put("U", 21);
        put("V", 22);
        put("W", 23);
        put("X", 24);
        put("Y", 25);
        put("Z", 26);
        }};

    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++) {
            int number = char2Int.get(chars[i]+"");
            sum = number + sum * 26;
        }
        return sum;
    }
}

