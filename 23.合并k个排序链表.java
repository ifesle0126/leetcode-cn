/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (48.79%)
 * Likes:    493
 * Dislikes: 0
 * Total Accepted:    74.1K
 * Total Submissions: 151.8K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length < 1) {
            return null;
        }
        for(int i = 1; i < lists.length; i++) {
            if(lists[0] == null && lists[i] == null) {
                continue;
            }
            if(lists[0] == null && lists[i] != null) {
                lists[0] = lists[i];
                continue;
            }
            if(lists[0] != null && lists[i] == null) {
                continue;
            }
            if(lists[0] != null && lists[0].val > lists[i].val) {
                ListNode tmp = lists[0];
                lists[0] = lists[i];
                lists[i] = tmp;
            }
            merge2List(lists[0], lists[i]);
        }
        return lists[0];
    }

    public void merge2List(ListNode list1, ListNode list2) {
        ListNode pre = list1;
        ListNode cur = list1.next;
        while(list2 != null) {
            if(cur == null) {
                pre.next = list2;
                list2 = list2.next;
                break;
            } else if(list2.val < cur.val && list2.val >= pre.val) {
                ListNode tmp = list2.next;
                pre.next = list2;
                list2.next = cur;
                pre = list2;
                cur = pre.next;
                list2 = tmp;
            } else {
                pre = cur;
                cur = pre.next;
            }
        }
    }
}
// @lc code=end

