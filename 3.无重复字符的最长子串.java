/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (33.08%)
 * Likes:    3231
 * Dislikes: 0
 * Total Accepted:    363.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */
import java.util.*;

// @lc code=start

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        
        return max;
    }
}


class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1) {
            return 0;
        }
        if(s.length() == 1)
            return 1;
        char[] chars = s.toCharArray();
        int b = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (b < chars.length - 1) {
            map.put(chars[b], b);
            int e = b + 1;
            while (e < chars.length) {
                Integer i = map.get(chars[e]);
                if(i == null) {
                    map.put(chars[e], e);
                    e++;
                } else {
                    int tmp = e - b;
                    if(max < tmp) {
                        max = tmp;
                    }
                    b = i + 1;
                    map.clear();
                    break;
                }
            }
            if(e == chars.length) {
                return max < e - b ? e - b : max;
            }
        }
        return max;
    }
}
// @lc code=end

