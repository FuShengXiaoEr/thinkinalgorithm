package org.chen.algorithm.leetcodepractice;

import java.util.ArrayList;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-25 11:10
 */
public class ReverseList {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre=null;//定义前一个节点
        ListNode now=head;//定义现在的节点
        while(now!=null)//循环条件：当前节点不为空
        {
            ListNode tem=now.next;//记录下当前节点的下一节点，防止指针反转后丢失后续节点
            now.next=pre;//当前节点的指针反转
            pre=now;//pre节点前进一个单位，接替now节点
            now=tem;//now节点前进一个节点，接替tem节点
        }
        return pre;//循环终止时now节点为null，此时前一个节点pre就是反转后链表的第一个节点
    }
    public ListNode recursion(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = recursion(head.next);
        // 这一步时关键，它将两个元素之间的关系对调了
        // 例如 3.next.next = 3 可以理解为3.next = 4;4.next = 3
        head.next.next = head;
        head.next = null;
        // 当前head是3，返回上一次函数则head是2，所以这里返回p是返回反转后的头节点
        return p;
    }

    public ListNode reverseList2(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if(head==null || head.next==null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

}
