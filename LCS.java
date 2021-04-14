import java.util.*;

public class LCS {
    
    public static void main(String[] args) {
        String s = LCS("22222","22222");

        System.out.println(s);

    }


    public static String LCS (String str1, String str2) {
        // if (str1.equals(str2)) {
        //     return str1;
        // }
        // write code here
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int[][] dp = new int[char2.length][char1.length];
        dp[0][0] = char1[0] == char2[0] ? 1 : 0;
        for (int i = 1; i < char1.length; i++) {
            if (char1[i] == char2[0]) {
                dp[0][i] = dp[0][i - 1] + 1;
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < char2.length; i++) {
            if (char1[0] == char2[i]) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = 0;
            }
        }
        int maxI = 0;
        int maxJ = 0;
        int max = 0;
        for (int i = 1; i < char2.length; i++) {
            for (int j = 1; j < char1.length; j++) {
                if (char2[i] == char1[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > max) {
                    maxI = i;
                    maxJ = j;
                    max = dp[i][j];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = maxI > maxJ ? char2 : char1;
        int index = maxI > maxJ ? maxI : maxJ;
        while (max > 0) {
            sb.insert(0, chars[index--]);
            max--;
        } 
        return sb.toString();
    }
}
