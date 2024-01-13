package com.cjh.ds.heap;

public class PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(30);
        System.out.println(pq.poll());
        pq.offer(1);
        pq.offer(4);
        pq.offer(2);
        pq.offer(5);
        pq.offer(3);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
    int size;
    int[] pq;
    public PriorityQueue(int size) {
        pq = new int[size];
    }

    public void offer(int num) {
        pq[size] = num;
        siftUp(size);
        size++;
    }

    public Integer peek() {
        if (size!=0) return pq[0];
        else return null;
    }

    public Integer poll() {
        Integer res = peek();
        if (size>0){
            swap(0, size - 1);
            size--;
            if (size>0) siftDown(0);
        }
        return res;
    }

    public void siftUp(int index) {
        if (index<=0) return;
        int parentIndex = (index - 1) / 2;
        if (pq[parentIndex]<pq[index]) {
            swap(parentIndex, index);
            siftUp(parentIndex);
        }

    }

    public void siftDown(int index) {
        int largest = index, l = 2 * index + 1, r = 2 * index + 2;
        if (l < size && pq[largest] < pq[l]) largest = l;
        if (r < size && pq[largest] < pq[r]) largest = r;
        if (largest != index) {
            swap(index, largest);
            siftDown(largest);
        }
    }

    public void swap(int i,int j){
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
}
