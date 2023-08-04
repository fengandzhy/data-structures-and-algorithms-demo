package org.zhouhy.structure.algorithms.circle.queue.demo01;

public class ArrayQueue {
    private int rear;
    private int front;
    private int amount;
    private int[] array;   
    
    public ArrayQueue(int size){
        rear = -1;
        front = -1;
        amount = 0;
        array = new int[size];        
    }
    
    
}
