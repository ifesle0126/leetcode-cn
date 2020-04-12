import java.util.*;

/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 *
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/description/
 *
 * algorithms
 * Hard (37.36%)
 * Likes:    195
 * Dislikes: 0
 * Total Accepted:    14K
 * Total Submissions: 37.4K
 * Testcase Example:  '[5,2,6,1]'
 *
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于
 * nums[i] 的元素的数量。
 * 
 * 示例:
 * 
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0] 
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * 
 * 
 */

// @lc code=start
/**
 * time limit
 */
class Solution {

    class Node{
        int val;
        int count;
        Node left;
        Node right;

        public Node (int val) {
            this.val = val;
            this.count = 0;
            this.left = null;
            this.right = null;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> r = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return r;
        }
        for (int i = 0; i < nums.length; i++) {
            r.add(0);
        }
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insertNode(root, new Node(nums[i]), i, r);
        }
        return r;
    }

    private Node insertNode(Node root, Node node, int i, List<Integer> r) {
        if (root == null) {
            root = node;
            return root;
        }
        if (root.val >= node.val) {
            root.count++;
            root.left = insertNode(root.left, node, i, r);
        } else {
            r.set(i, r.get(i) + root.count + 1);
            root.right = insertNode(root.right, node, i, r);
        }
        return root;
    }
}


class Solution2 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> r =  new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return r;
        }
        Integer[] smaller_right = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int c = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < n) {
                    c++;
                }
            }
            smaller_right[i] = c;
        }
        return Arrays.asList(smaller_right);

    }
}
// @lc code=end

