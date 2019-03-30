/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (35.78%)
 * Total Accepted:    19K
 * Total Submissions: 53.2K
 * Testcase Example:  '[1,2]'
 *
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2
 * 输出: false
 * 
 * 示例 2:
 * 
 * 输入: 1->2->2->1
 * 输出: true
 * 
 * 
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
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
import java.util.*;


// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }

class Solution {


    public boolean isPalindrome(ListNode head) {
            if(head == null) {
                return true;
            }
            ListNode p1 = head;
            ListNode p2 = head;
            ListNode p3 = p1.next;
            ListNode pre = p1;
            //find mid pointer, and reverse head half part
            while(p2.next != null && p2.next.next != null) {
                p2 = p2.next.next;
                pre = p1;
                p1 = p3;
                p3 = p3.next;
                p1.next = pre;
            }
    
            //odd number of elements, need left move p1 one step
            if(p2.next == null) {
                p1 = p1.next;
            }
            //compare from mid to head/tail
            while(p3 != null) {
                if(p1.val != p3.val) {
                    return false;
                }
                p1 = p1.next;
                p3 = p3.next;
            }
            return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode node = head;
        ListNode node2 = head;
        ListNode pre = null;
        ListNode tmp = null; 
        // 寻找中间节点 并反转从开始到中间节点的一段链表
        while(node2 != null && node2.next != null) {
            node2 = node2.next.next;
            ListNode next = node.next;
            node.next = tmp;
            pre = tmp;
            tmp = node;
            node = next;
        }
        // 链表开始位置 和 链表中间位置 一一比较
        while(pre != null && head != null) {
            if(pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }
}

