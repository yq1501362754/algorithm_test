package org.demo.test;


import org.junit.jupiter.api.Test;


public class TwoNumbersSum {

  public class ListNode {

    private int val;
    private ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    public ListNode(int val) {
      this.val = val;
    }

    public int getVal() {
      return val;
    }

    public void setVal(int val) {
      this.val = val;
    }

    public ListNode getNext() {
      return next;
    }

    public void setNext(ListNode next) {
      this.next = next;
    }

    @Override
    public String toString() {
      return "ListNode{" + "val=" + val + ", next=" + next + '}';
    }
  }

  /**
   * @author yanqi 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
   * <p>
   * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
   * <p>
   * 你可以按任意顺序返回答案。
   * <p>
   * 示例 1：
   * <p>
   * 输入：nums = [2,7,11,15], target = 9 输出：[0,1] 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
   */
  private int[] sum(int data[], int result) {
    for (int i = 0; i < data.length; i++) {
      int i1 = data[i];
      for (int j = 0; i > j; j++) {
        if (i1 + data[j] == result) {
          return new int[]{i, j};
        }
      }
    }

    return null;
  }

  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next
   * = next; } } 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
   * <p>
   * 请你将两个数相加，并以相同形式返回一个表示和的链表。
   * <p>
   * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
   * <p>
   * 输入：l1 = [2,4,3], l2 = [5,6,4] 输出：[7,0,8] 解释：342 + 465 = 807. 输入：l1 = [0], l2 = [0] 输出：[0]
   * <p>
   * <p>
   * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] 输出：[8,9,9,9,0,0,0,1]
   * <p>
   * 提示： 每个链表中的节点数在范围 [1, 100] 内 0 <= Node.val <= 9 题目数据保证列表表示的数字不含前导零
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode current = result;
    int prev = 0;
    while (l1 != null || l2 != null) {
      int x = l1 != null ? l1.getVal() : 0;
      int y = l2 != null ? l2.getVal() : 0;
      int sum = x + y + prev;
      //计算进位数
      prev = sum / 10;
      //取余
      sum = sum % 10;
      current.setNext(new ListNode(sum));
      current = current.getNext();
      if (l1 != null) {
        l1 = l1.getNext();
      }
      if (l2 != null) {
        l2 = l2.getNext();
      }
      if (prev == 1) {
        current.setNext(new ListNode(prev));
      }

    }
    return result.getNext();
  }

  @Test
  public void sumTest() {
    int data[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    int result[] = sum(data, 8);
    System.out.println(result[0] + "," + result[1]);

  }

  @Test
  public void addTwoNumbersTest() {
    ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

    ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
    ListNode l = addTwoNumbers(l1, l2);
    System.out.println(l.toString());
  }

}
