import java.util.*;

/**
 * 给定两个字符串str1和str2，再给定三个整数ic，dc和rc，分别代表插入、删除和替换一个字符的代价，请输出将str1编辑成str2的最小代价
 * 
 * 输入："abc","adc",5,3,2
 * 返回：2
 */
public class MinEditCost {
    
    public static void main(String[] args) {

        // String str1 = "xhcjhjsrjamxkjdbiqnqjxfsugywrpceyuniviqdynpipfytbaijwsjnhynxnwzydyxmrqlxnygttbaqsneejojukjkkxrsxyywmnsgcuxbnnavmytbthosfuhzytripxthaciiupodunllqz";
        // String str2 = "xmhjrtsajahxkjialbtfgrikbepnwqnjrrxfsssgyvrnrmocxuqshmvwqsphyqndipxabbsaijjbnxnxjnywndyxscmrlvnarvtgbwaqgsgjeegazofjmuiocjlxwemyyywmsgyuxnmjmytvybgyghcxtsfuhzyqzhdhsdviokpmstgciaukbkpniotddnvmqz";
        // int ic = 6477;
        // int dc = 7414;
        // int rc = 1063;

        String str1 = "fbnbqsputklmmwrdqszwgxzgxrevqhautncdzsmlllufqifhkadoqgqpwemiposathdxdgfrjqmtjwrmchxpbcobozdwpepsiivt";
        String str2 = "rbxfspcdputlzxrmwpdusqcpafszfdwosxzgmezhcuucdgwsmleznbaullannbzevifqdhvizdgqgpbenmuposatafhedjdevoxgfqlamtafmgrmlmhxvouswipvvxjrecoupbdiuqwnpucesiyvt";
        int ic = 6325;
        int dc = 2459;
        int rc = 3712;

        // String str1 = "abc";
        // String str2 = "adc";
        // int ic = 5;
        // int dc = 3;
        // int rc = 2;


        System.out.println(minEditCost(str1, str2, ic, dc, rc));

    }

    public static int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        // write code here
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int[][] dp = new int[char2.length + 1][char1.length + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= char1.length; i++) {
            dp[0][i] = dp[0][i-1] + ic;
        }
        for (int i = 1; i <= char2.length; i++) {
            dp[i][0] = dp[i - 1][0] + dc;
        }
        for (int i = 1; i <= char2.length; i++) {
            for (int j = 1; j <= char1.length; j++) {
                if (char1[j - 1] == char2[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + dc);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + ic);
            }
        }
        return dp[char2.length][char1.length];
    }
}
