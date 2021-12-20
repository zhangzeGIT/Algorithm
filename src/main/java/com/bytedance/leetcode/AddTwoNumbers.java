package com.bytedance.leetcode;

/**
 * 2. Add Two Numbers
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode();
        ListNode currentNode = head;
        while (l1 != null || l2 != null) {
            ListNode next = new ListNode();
            currentNode.next = next;
            int int1 = l1 == null? 0 : l1.val;
            int int2 = l2 == null? 0 : l2.val;
            next.val = (carry + int1 + int2) % 10;
            carry = (carry + int1 + int2) / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            currentNode = next;
        }
        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }
        return head.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}