/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * algorithms
 * Easy (48.52%)
 * Total Accepted:    33.1K
 * Total Submissions: 68K
 * Testcase Example:  '[7,1,5,3,6,4]'
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 
 * 注意你不能在买入股票前卖出股票。
 * 
 * 示例 1:
 * 
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * ⁠    注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 
 * 
 */
class Solution {


    public int maxProfit(int[] prices) {
        int profit[][] = new int[prices.length][2];
        profit[0][1] = -prices[0];
        profit[0][0] = 0;
        for(int i=1; i<prices.length; i++){
            profit[i][1] = Math.max(profit[i-1][1], -prices[i]);
            profit[i][0] = Math.max(profit[i-1][0], profit[i-1][1]+prices[i]);
        }
        return profit[prices.length-1][0];
    }

// '[2,1,2,1,0,1,2]'
    public int maxProfit3(int[] prices) {
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        int minItem = prices[0];
        int maxGap = 0;
        for(int i = 1; i < prices.length; i++) {
            if(minItem > prices[i]) {
                minItem = prices[i];
            } else if(prices[i] - minItem > maxGap) {
                maxGap = prices[i] - minItem;
            }
        }
        return maxGap;
    }

    public int maxProfit2(int[] prices) {
        int max = 0;
        for(int i = 0; i < prices.length; i++) {
            int innerMax = 0;
            int beg = prices[i];
            for(int j = i + 1; j < prices.length; j++) {
                if(innerMax < prices[j]) {
                    innerMax = prices[j];
                }
            }
            int ii = innerMax - beg;
            if (max < ii) {
                max = ii;
            }
        }
        return max;
    }
}

