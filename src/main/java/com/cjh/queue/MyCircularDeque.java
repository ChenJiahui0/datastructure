package com.cjh.queue;

class MyCircularDeque {
    int front, rear, size;
    int[] q;

    public MyCircularDeque(int k) {
        q = new int[k];
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(1);
        myCircularDeque.insertLast(2);
        myCircularDeque.insertFront(3);
        myCircularDeque.insertFront(4);
        myCircularDeque.getRear();
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            front = (front - 1 + q.length) % q.length;
            q[front] = value;
            size++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            q[(++rear) % q.length] = value;
            size++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            size--;
            front++;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            size--;
            rear--;
            return true;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return q[front % q.length];
        }
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return q[rear % q.length];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == q.length;
    }
}
