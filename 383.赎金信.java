/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 *
 * https://leetcode-cn.com/problems/ransom-note/description/
 *
 * algorithms
 * Easy (46.49%)
 * Total Accepted:    5.9K
 * Total Submissions: 12.7K
 * Testcase Example:  '"a"\n"b"'
 *
 * 给定一个赎金信 (ransom)
 * 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回
 * true ；否则返回 false。
 * 
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * 
 * 注意：
 * 
 * 你可以假设两个字符串均只含有小写字母。
 * 
 * 
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * 
 */

import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()){
            Integer old = map.put(c, 1);
            if (old != null) {
                map.put(c, old + 1);
            }
        }
        for(char c : ransomNote.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                return false;
            }
            if(count == 1) {
                map.remove(c);
            } else {
                map.put(c, count -1);
            }
        }
        return true;
    }
}

