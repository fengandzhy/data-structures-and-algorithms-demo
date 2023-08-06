package org.zhouhy.structure.algorithms.circle.queue.demo02;

/**
 * 这里的
 * */
public class SimpleQueue {
    private int[] arr;
    private int begin;
    private int end;
    private int amount;
    
    public SimpleQueue(int maxSize){
        this.arr = new int[maxSize];
        this.begin = -1; // begin 在头元素之前的位置        
        this.end = -1; // end 是队列尾部元素
        this.amount = 0;
    }
    
    public boolean isEmpty(){
        return amount == 0;
    }
    
    public boolean isFull(){
        return amount == arr.length;
    }
    
    public void push(int a){
        if(isFull()){
            throw new RuntimeException("The queue is full!");
        }
        end = end+1;
        if(end == arr.length){
            end =0;
        }
        arr[end] = a;
        System.out.println(a+" is pushed into the queue.");
        amount ++;
    }
    
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("The queue is empty!");
        }
        begin = begin +1;
        if(begin == arr.length){
            begin =0;
        }
        amount--;
        return arr[begin];        
    }
    
    public void showQueue(){
        int index = begin+1;
        int size = this.amount;
        while(size>0){            
            if(index == arr.length){
                index =0;
            }
            System.out.printf("arr[%d]=%d\n",index,arr[index]);
            index ++;
            size --;
        }
    }
}
