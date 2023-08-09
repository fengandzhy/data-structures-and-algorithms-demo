package org.zhouhy.structure.algorithms.circle.queue.demo01;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class ArrayQueueTest {
    private ArrayQueue arrayQueue;

    @Before
    public void setUp(){
        arrayQueue = new ArrayQueue(3);
    }

    @Test
    public void test1(){
        boolean isEmpty = arrayQueue.isEmpty();
        assertTrue(isEmpty);
    }

    @Test
    public void test2(){
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        boolean isFull = arrayQueue.isFull();
        assertTrue(isFull);
    }

    @Test
    public void test3(){
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        try{
            arrayQueue.push(4);
        }catch(Exception ex){            
            assertTrue(ex.getMessage().contains("The queue is full."));
        }
        boolean isFull = arrayQueue.isFull();
        assertTrue(isFull);
    }

    @Test
    public void test4(){
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        int a = arrayQueue.pop();
        assertEquals(1,a);
        a = arrayQueue.pop();
        assertEquals(2,a);
        a = arrayQueue.pop();
        assertEquals(3,a);
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void test5(){
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        int a = arrayQueue.pop();
        arrayQueue.push(4);
        assertTrue(arrayQueue.isFull());
        assertEquals(1,a);
    }

    @Test
    public void test6(){
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.pop();
        arrayQueue.pop();
        arrayQueue.pop();
        try {
            arrayQueue.pop();
        } catch (Exception ex) {            
            assertTrue(ex.getMessage().contains("The queue is empty."));
        }
    }

    @Test
    public void test7(){
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.showQueue();
        System.out.println();
        arrayQueue.pop();
        arrayQueue.pop();
        arrayQueue.pop();
        arrayQueue.showQueue();
        arrayQueue.push(4);
        System.out.println();
        arrayQueue.showQueue();
    }
}
