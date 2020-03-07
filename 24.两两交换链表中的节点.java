/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (64.67%)
 * Likes:    427
 * Dislikes: 0
 * Total Accepted:    78K
 * Total Submissions: 120.6K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while (curr != null && next != null) {
            ListNode tmp = next.next;
            next.next = curr;
            curr.next = tmp;
            if (pre == null) {
                head = next;
            } else {
                pre.next = next;
            } 
            pre = curr;

            if (tmp == null) {
                break;
            }
            curr = tmp;
            next = curr.next;

        }
        return head;
    }
}
// @lc code=end

