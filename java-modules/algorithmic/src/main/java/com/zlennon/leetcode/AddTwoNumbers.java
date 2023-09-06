package com.zlennon.leetcode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 动态图演示 https://github.com/MisterBooo/LeetCodeAnimation
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode cur = null;
        ListNode SS=  addTwoNumbers(head,cur,l1, l2, 0);
        return  SS;
    }

    // * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    private ListNode addTwoNumbers(ListNode head, ListNode cur, ListNode l1, ListNode l2, int carry) {
        if(l1==null&&l2==null&&carry==0)
            return head;
        carry += (l1==null?0:l1.val)+(l2==null?0:l2.val);
        int val=carry%10;
        ListNode temp =new ListNode(val);
        if(cur==null){
            head = temp;
            cur = head;
        }else {
            cur.next = temp;
            cur = cur.next;
        }
            return addTwoNumbers(head,cur, l1==null?l1:l1.next, l2==null?l2:l2.next, carry / 10);
    }


    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 =new ListNode(2);
        l1.next =new ListNode(4);
        l1.next.next =new ListNode(5);
        ListNode l2 =new ListNode(5);
        l2.next =new ListNode(5);
        l2.next.next =new ListNode(6);
        addTwoNumbers.addTwoNumbers(l1,l2);
    }

    //  Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
