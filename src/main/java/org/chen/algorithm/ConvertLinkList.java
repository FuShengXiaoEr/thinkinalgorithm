package org.chen.algorithm;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-09-15 23:10
 */
public class ConvertLinkList {
    static class Node{
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }
   static void printChain(Node head){
        StringBuilder sb = new StringBuilder();
        Node no = head;
        sb.append(no.value);
        while (null != no.next) {
            sb.append("->");
            sb.append(no.next.value);
            no = no.next;
        }
        System.out.println(sb.toString());
    }

    public Node reverse(Node head){
        if (head == null || head.next ==null) {
            return head;
        }
        Node temp = head.next;
        Node newHead = reverse(temp);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Node no1 = new Node(1);
        Node no2 = new Node(2);
        no1.next = no2;
        Node no3 = new Node(3);
        no2.next = no3;
        Node no4 = new Node(4);
        no3.next = no4;

        printChain(no1);

    }
}
