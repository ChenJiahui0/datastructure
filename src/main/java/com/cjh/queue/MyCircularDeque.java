package com.cjh.queue;


class MyCircularDeque {
    int front,rear,size;
    int[] q;
    public MyCircularDeque(int k) {
        q = new int[k];
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        int index = 1;
        System.out.println(a[++index]);
    }

    public boolean insertFront(int value) {
        if(isFull()) return false;
        if(!isEmpty()){
            front = (front+q.length-1)%q.length;
        }
        size++;
        q[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()) return false;
        if(!isEmpty()) rear = (rear+1)%q.length;
        size++;
        q[rear] = value;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()) return false;
        size--;
        front = front == rear ? rear : (front+1)%q.length;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) return false;
        size--;
        rear = rear == front ? front : (rear+q.length-1)%q.length;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : q[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : q[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == q.length;
    }
}