package org.frank.structure.algorithms.stack.array;

public class  ArrayStack<T>  {
    private int maxSize;
    private int top;
    private T[] stack;
    
    
    public ArrayStack (int maxSize){
        this.top = -1;
        this.maxSize = maxSize;
        this.stack = (T[])new Object[maxSize]; // 注意这里创建的是一个泛型数组
    }
    
    public boolean isFull(){
        return top == maxSize -1;
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
    
    public void push(T data){
        if(this.isFull()){
            throw new RuntimeException("The stack is full.");
        }
        this.top ++;
        stack[top] = data;
    }
    
    public T pop(){
        if(this.isEmpty()){
            throw new RuntimeException("The stack is empty.");
        }        
        this.top --;
        return stack[top+1];
    }   
}
