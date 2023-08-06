package org.zhouhy.structure.algorithms.circle.queue.demo01;

public class ArrayQueue {
    private int rear;
    private int front;
    private int[] array;

    public ArrayQueue(int size) {
        rear = -1; // 指向的尾部元素
        front = -1; // 指向头部元素
        array = new int[size];
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public boolean isFull() {
        return rear + 1 == front || rear - front == array.length - 1;
    }

    public void push(int value) {        
        if (isFull()) {
            throw new RuntimeException("The queue is full.");
        }
        if (rear == -1 && front == -1) {
            rear = 0;
            front = 0;                              
        } else if (rear == array.length - 1) {
            rear = 0;
        } else {
            rear++;
        }
        array[rear] = value;
    }

    public int pop() {
        int returnValueIndex;
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty.");
        }
        if (rear == front) {
            returnValueIndex = front;
            rear = -1;
            front = -1;
            return array[returnValueIndex];
        } else if (front == array.length - 1) {
            returnValueIndex = front;
            front = 0;
            return array[returnValueIndex];
        } else {
            returnValueIndex = front;
            front++;
            return array[returnValueIndex];
        }
    }

    public void showQueue() {
        if(rear < front ){
            for (int i = front; i < array.length; i++) {
                System.out.printf("arr[%d]=%d\n", i, array[i]);
            }
            for (int i = 0; i <= rear; i++) {
                System.out.printf("arr[%d]=%d\n", i, array[i]);
            }
        } else {
            for (int i = front; i <= rear ; i++) {
                System.out.printf("arr[%d]=%d\n", i, array[i]);
            }
        }
        
    }
}
