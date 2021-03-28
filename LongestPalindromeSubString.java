/**
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。给定字符串A以及它的长度n，请返回最长回文子串的长度。
 *
 *  输入
 *  "abc1234321ab",12
 *  返回值
 *  7
 */
public class LongestPalindromeSubString {
    
    public static void main(String[] args) {

        System.out.println(LongestPalindromeSubString("acbdcbbbdbdaaccbcacdacdccababcddabddaaaaaaabdbabcdddaacabacbacbbdabdacddbbadaacbbdcbccacacdabcabacacbbbdcccacdcdcdcbcbabdcdacdddbbabcaccddddddabdacaabccdcabcbcbabacaaaccaccaddabbdadcdacdcdbaadbcabdcdcaaacbcadccbbddbaddcaddcaadcbbcbbdcbdadcddabdddcdbddbbdabaaddcaadd"));
    }

    public static int LongestPalindromeSubString(String A) {
        char[] chars = A.toCharArray();
        int max = 0;
        for(int i = 1; i < A.length() - 1; i++) {
            int one = LongestPalindromeSubString(chars, i, i);
            int two = LongestPalindromeSubString(chars, i, i + 1);
            int tmp = Math.max(one, two);
            max = Math.max(max, tmp);
        }
        return max;
    }

    public static int LongestPalindromeSubString(char[] chars, int i, int j) {
        if (chars[i] != chars[j]) {
            return 0;
        }
        while (i >= 0 && j < chars.length) {
            if(chars[i] == chars[j]) {
                i--;j++;
            } else {
                break;
            }
        }
        return j - i - 1;
    }
}
