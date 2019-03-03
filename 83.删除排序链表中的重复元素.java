/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (43.86%)
 * Total Accepted:    17.2K
 * Total Submissions: 39.1K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * 示例 1:
 * 
 * 输入: 1->1->2
 * 输出: 1->2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//  class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
//  }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null) {
            if(p1.val == p2.val) {
                p1.next = p2.next;
                p2 = p2.next;
            } else {
                p1 = p2;
                p2 = p2.next;
            }
        }
        return head;

    }
}

