/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;


class Solution {

    // class TreeNode {
    //     int val;
    //     TreeNode left;
    //     TreeNode right;
    //     TreeNode(int x) { val = x; }
    // }

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        findMode(root, list);
        if(list == null || list.size() < 1) {
            return new int[0];
        }
        List<Integer> re = new ArrayList<>();
        int pre = list.get(0);
        re.add(pre);
        int count = 1;
        int max = 1;
        for (int i = 1; i < list.size(); i++) {
            int n = list.get(i);
            if(n == pre) {
                count++;
            } else {
                count = 1;
                pre = n;
            }
            if(count == max) {
                re.add(n);
            }
            if(count > max) {
                re.clear();
                re.add(n);
                max = count;
            }
        }
        int[] ii = new int[re.size()];
        for (int i = 0; i < ii.length; i++) {
            ii[i] = re.get(i);
        }
        return ii;
    }

    public void findMode(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        findMode(node.left, list);
        list.add(node.val);
        findMode(node.right, list);
    }
}

