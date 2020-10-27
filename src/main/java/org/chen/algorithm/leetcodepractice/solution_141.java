package org.chen.algorithm.leetcodepractice;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否有环
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-28 05:59
 */
public class solution_141 {
    public boolean hasCycle(ListNode head) {
        return hasDuplicate(head);
    }

    /**
     * 硬做，判断节点中是否有空值，有空值则无环
     */
    public boolean hasNull(ListNode head){
        long start = System.currentTimeMillis();
        while(head != null) {
            head = head.next;
        }
        long end = System.currentTimeMillis();
        if ((end - start) > 500 ){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 利用set存储起来。判断是否有重复值，有则有环
     */
    public boolean hasDuplicate(ListNode node){
        Set<ListNode> value = new HashSet<>();
        while(node != null){
            if (!value.add(node)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 快慢针
     */
    public boolean fastAndSlowPointer(ListNode head){
        if (head == null || head.next == null){
           return false;
        }else if (head.next.next == null){
            if (head == head.next){
                return true;
            }
        }
        ListNode slow  = head.next;
        ListNode fast = head.next.next;
        while(fast != null && slow != null){
            if (fast == slow){
                return true;
            }
            // 判断为空，可以判断fast.next不为空就行。这样fast.next.next就不会报空指针异常
            if (fast == null || fast.next == null){
                return  false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    /**
     * 代码改进
     */
    public boolean fastAndSlowPointer1(ListNode head){
        if (head == null || head.next == null ){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast !=  slow){
            // 这里只要判断fast是否为空，因为fast永远比slow先到达边界
            if (fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

}
