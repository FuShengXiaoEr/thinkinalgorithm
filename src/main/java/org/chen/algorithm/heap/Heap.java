package org.chen.algorithm.heap;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-08-01 15:22
 */
public class Heap {
    private int[] a; // 数组，从下标1开始存储
    private int n; //堆可以存储的最大个数
    private int count; // 堆中已经存储的元素

    // 堆是完全二叉树，瓦全二叉树用数组存储时为了方便计算子节点
    // 因此会浪费下标为0的元素,所以capacity要加1
    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    // 自下往上堆化
    public void insert(int data) {
        if (count >= n) {
            return;
        }
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    public void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public int removeMax(){
        if(count == 0){
            return -1;
        }
        a[1] = a[count];
        --count;
        heapify(a,count,1);
        return 0;
    }

    // 自上向下堆化
    private void heapify(int[] a,int count,int i){
        while(true){
            int maxPosition = i;
            if(i*2 <= n && a[i] < a[i*2]){
                maxPosition = i*2;
            }
            if (i*2 +1 <= n && a[maxPosition] < a[i*2 +1] ){
                maxPosition = i*2 +1;
            }
            if (maxPosition ==i){
                break;
            }
            swap(a,i,maxPosition);
            i = maxPosition;
        }
    }

    public static void main(String[] args) {
        int[] arr = {33, 17, 21, 16, 13, 15, 9, 5, 6, 7, 8, 1, 2};
        Heap heap = new Heap(13);
        heap.insert(33);
        heap.insert(17);
        heap.insert(21);
        heap.insert(16);
        heap.insert(13);
        heap.insert(15);
        heap.insert(9);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        heap.printArray(heap.a);

        heap.removeMax();
        System.out.println("remove max:");
        heap.printArray(heap.a);

    }

    public void printArray(int[] a){
        for (int i=1;i<a.length;i++){
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }
}
