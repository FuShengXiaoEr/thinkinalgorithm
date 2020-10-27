package org.chen.algorithm.leetcodepractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-28 07:29
 */
public class Solution_142 {
    public ListNode detectCycle(ListNode head) {

    }

    /**
     * 利用set判断是否重复，获取第一个入环
     */
    public ListNode isDupblicate(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        int index = 0;
        while(head != null){
            if(!set.add(head)){
                List<ListNode> list = new ArrayList<>(set);
                return list.get(index);
            }
            if (head == null || head.next == null) {
                return null;
            }
            head = head.next;
        }
    }
}
