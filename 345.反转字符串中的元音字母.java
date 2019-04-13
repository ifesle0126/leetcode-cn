/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 *
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (45.99%)
 * Total Accepted:    8.1K
 * Total Submissions: 17.7K
 * Testcase Example:  '"hello"'
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * 示例 1:
 * 
 * 输入: "hello"
 * 输出: "holle"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 
 * 说明:
 * 元音字母不包含字母"y"。
 * 
 */

import java.util.*;

class Solution {

    private Set<Character> set = new HashSet<Character>(){{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }};

    public String reverseVowels(String s) {
        char[] sArr = s.toCharArray();
        int beg = 0;
        int end = sArr.length - 1;
        while (beg < end) {
            boolean begF = set.contains(sArr[beg]);
            boolean endF = set.contains(sArr[end]);
            if ( begF && endF) {
                char tmp = sArr[beg];
                sArr[beg] = sArr[end];
                sArr[end] = tmp;
                beg++;
                end--;
            }
            if (!begF) {
                beg++;
            }
            if(!endF) {
                end--;
            }
            
        }
        return new String(sArr);
    }
}

