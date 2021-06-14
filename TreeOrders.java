import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class TreeOrders {

    /**
     * 
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        int[][] re = new int[3][];
        List<Integer> list = new ArrayList<>();
        frontTreeOrder(root, list);
        int[] reLine = new int[list.size()];
        for (int i = 0; i < reLine.length; i++) {
            reLine[i] = list.get(i);
        }
        re[0] = reLine;
        list.clear();
        midTreeOrder(root, list);
        reLine = new int[list.size()];
        for (int i = 0; i < reLine.length; i++) {
            reLine[i] = list.get(i);
        }
        re[1] = reLine;
        list.clear();
        afterTreeOrder(root, list);
        reLine = new int[list.size()];
        for (int i = 0; i < reLine.length; i++) {
            reLine[i] = list.get(i);
        }
        re[2] = reLine;
        return re;
    }

    public void frontTreeOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        frontTreeOrder(node.left, list);
        frontTreeOrder(node.right, list);

    }

    public void midTreeOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        midTreeOrder(node.left, list);
        list.add(node.val);
        midTreeOrder(node.right, list);
    }

    public void afterTreeOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        afterTreeOrder(node.left, list);
        afterTreeOrder(node.right, list);
        list.add(node.val);

    }


}
