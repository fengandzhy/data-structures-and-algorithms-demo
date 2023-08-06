package org.zhouhy.structure.algorithms.circle.queue.demo02;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {
    
    private SimpleQueue simpleQueue;
    
    @Before
    public void setUp(){
        simpleQueue = new SimpleQueue(3);
    }
    
    @Test
    public void test1(){
        boolean isEmpty = simpleQueue.isEmpty();
        assertThat(isEmpty, is(true));
    }

    @Test
    public void test2(){
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        boolean isFull = simpleQueue.isFull();
        assertThat(isFull, is(true));
    }

    @Test
    public void test3(){
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        try{
            simpleQueue.push(4);
        }catch(Exception ex){
            assertTrue(ex instanceof  RuntimeException);
            assertTrue(ex.getMessage().contains("The queue is full!"));
        }        
        boolean isFull = simpleQueue.isFull();
        assertThat(isFull, is(true));
    }

    @Test
    public void test4(){
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        int a = simpleQueue.pop();
        assertEquals(a,1);
        a = simpleQueue.pop();
        assertEquals(a,2);
        a = simpleQueue.pop();
        assertEquals(a,3);
        assertTrue(simpleQueue.isEmpty());
    }

    @Test
    public void test5(){
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        int a = simpleQueue.pop();
        simpleQueue.push(4);
        assertTrue(simpleQueue.isFull());
    }

    @Test
    public void test6(){
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        simpleQueue.pop();
        simpleQueue.pop();
        simpleQueue.pop();
        try {
            simpleQueue.pop();
        } catch (Exception ex) {
            assertTrue(ex instanceof  RuntimeException);
            assertTrue(ex.getMessage().contains("The queue is empty!"));
        }
    }

    @Test
    public void test7(){
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        simpleQueue.showQueue();
        simpleQueue.pop();
        simpleQueue.pop();
        simpleQueue.pop();
        simpleQueue.showQueue();
    }
}
