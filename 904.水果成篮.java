/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] 水果成篮
 *
 * https://leetcode-cn.com/problems/fruit-into-baskets/description/
 *
 * algorithms
 * Medium (43.05%)
 * Likes:    67
 * Dislikes: 0
 * Total Accepted:    10.3K
 * Total Submissions: 23.9K
 * Testcase Example:  '[1,2,1]'
 *
 * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
 * 你可以从你选择的任何树开始，然后重复执行以下步骤：
 * 
 * 
 * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
 * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
 * 
 * 
 * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
 * 
 * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
 * 
 * 用这个程序你能收集的水果树的最大总量是多少？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[1,2,1]
 * 输出：3
 * 解释：我们可以收集 [1,2,1]。
 * 
 * 
 * 示例 2：
 * 
 * 输入：[0,1,2,2]
 * 输出：3
 * 解释：我们可以收集 [1,2,2]
 * 如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
 * 
 * 
 * 示例 3：
 * 
 * 输入：[1,2,3,2,2]
 * 输出：4
 * 解释：我们可以收集 [2,3,2,2]
 * 如果我们从第一棵树开始，我们将只能收集到 [1, 2]。
 * 
 * 
 * 示例 4：
 * 
 * 输入：[3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：我们可以收集 [1,2,1,1,2]
 * 如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 棵水果树。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= tree.length <= 40000
 * 0 <= tree[i] < tree.length
 * 
 * 
 */
import java.util.*;
// @lc code=start

class Solution2 {
    public int totalFruit(int[] tree) {
        int ans = 0, i = 0;
        Counter count = new Counter();
        for (int j = 0; j < tree.length; ++j) {
            count.add(tree[j], 1);
            while (count.size() >= 3) {
                count.add(tree[i], -1);
                if (count.get(tree[i]) == 0)
                    count.remove(tree[i]);
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}

class Counter extends HashMap<Integer, Integer> {
    public int get(int k) {
        return containsKey(k) ? super.get(k) : 0;
    }

    public void add(int k, int v) {
        put(k, get(k) + v);
    }
}


class Solution {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length < 1) {
            return 0;
        }
        if(tree.length <= 2) {
            return tree.length;
        }
        int i = 0;
        Set<Integer> set = new HashSet<>();
        int len = 0;
        while (i < tree.length) {
            int j = i;
            while (j < tree.length) {
                if (set.size() < 2) {
                    set.add(tree[j++]);
                } else if (set.contains(tree[j])) {
                    j++;
                } else {
                    break;
                }
            }
            len = Math.max(len, j - i);
            if (j == tree.length) {
                return len;
            }
            set.clear();
            i = j - 1;
            while (i - 1 >= 0 && tree[i - 1] == tree[i]) {
                i--;
            }
        }
        return len;
    }
}
// @lc code=end

