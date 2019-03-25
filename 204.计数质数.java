/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 *
 * https://leetcode-cn.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (26.75%)
 * Total Accepted:    14.2K
 * Total Submissions: 53.1K
 * Testcase Example:  '10'
 *
 * 统计所有小于非负整数 n 的质数的数量。
 * 
 * 示例:
 * 
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 
 * 
 */
class Solution {


    /**
     * 厄拉多塞筛法. 
     * 首先0,1不是质数.2是第一个质数,然后把20以内所有2的倍数划去.
     * 2后面紧跟的数即为下一个质数3,然后把3所有的倍数划去.
     * 3后面紧跟的数即为下一个质数5,
     * 再把5所有的倍数划去.
     * 以此类推.
     */
    public int countPrimes(int n) {
        if (n < 3)
        return 0;
        
        boolean[] f = new boolean[n];
        //Arrays.fill(f, true); boolean[] are initialed as false by default
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (f[i])
                continue;
            
            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }


    public int countPrimes2(int n) {
        if ( n < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

