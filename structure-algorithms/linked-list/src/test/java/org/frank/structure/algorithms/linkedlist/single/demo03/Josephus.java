package org.frank.structure.algorithms.linkedlist.single.demo03;

import org.junit.Test;

public class Josephus {
    
    @Test
    public void testJosephus(){
        CycleLinkedList cycleLinkedList = new CycleLinkedList();
        cycleLinkedList.add(30);
        cycleLinkedList.josephusProblem(3,6);        
    }

    @Test
    public void testJosephus2(){
        CycleLinkedList cycleLinkedList = new CycleLinkedList();
        cycleLinkedList.add(30);
        cycleLinkedList.josephusProblem2(3,6);
    }
}
