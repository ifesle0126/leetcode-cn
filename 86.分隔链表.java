/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 *
 * https://leetcode.cn/problems/partition-list/description/
 *
 * algorithms
 * Medium (64.58%)
 * Likes:    827
 * Dislikes: 0
 * Total Accepted:    274.5K
 * Total Submissions: 425K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 
 * -200 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        ListNode smaller = new ListNode(-1);
        ListNode bigger = new ListNode(-1);
        ListNode firstPart = smaller;
        ListNode secondPart = bigger;
        while (node != null) {
            if (node.val < x) {
                smaller.next = node;
                smaller = smaller.next;
            } else {
                bigger.next = node;
                bigger = bigger.next;
            }
            ListNode tmp = node.next;
            node.next = null;
            node = tmp;
        }
        smaller.next = secondPart.next;
        return firstPart.next;

    }
}
// @lc code=end

