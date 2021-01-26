/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 *
 * https://leetcode-cn.com/problems/interleaving-string/description/
 *
 * algorithms
 * Hard (45.73%)
 * Likes:    391
 * Dislikes: 0
 * Total Accepted:    40.1K
 * Total Submissions: 87.7K
 * Testcase Example:  '"aabcc"\n"dbbca"\n"aadbbcbcac"'
 *
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * 
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * 
 * 
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| 
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 +
 * ...
 * 
 * 
 * 提示：a + b 意味着字符串 a 和 b 连接。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * 0 
 * s1、s2、和 s3 都由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] s1_arr = s1.toCharArray();
        char[] s2_arr = s2.toCharArray();
        char[] s3_arr = s3.toCharArray();

        if (s3_arr.length != s1_arr.length + s2_arr.length) {
            return false;
        }

        boolean[][] db = new boolean[s1_arr.length + 1][s2_arr.length + 1];
        db[0][0] = true;
        for (int i = 1; i <= s1_arr.length; i++) {
            if (s1_arr[i - 1] != s3_arr[i - 1]) {
                break;
            }
            db[i][0] = true;
        }
        for (int j  = 1; j <= s2_arr.length; j++) {
            if (s2_arr[j - 1] != s3_arr[j - 1]) {
                break;
            }
            db[0][j] = true;
        }
        for (int i = 1; i <= s1_arr.length; i++) {
            for (int j = 1; j <= s2_arr.length; j++) {
                if((s1_arr[i - 1] == s3_arr[i + j - 1] && db[i - 1][j]) ||
                    (s2_arr[j - 1] == s3_arr[i + j - 1] && db[i][j - 1])) {
                    db[i][j] = true;
                }
            }
        }
        return db[s1_arr.length][s2_arr.length];
    }
}
// @lc code=end

