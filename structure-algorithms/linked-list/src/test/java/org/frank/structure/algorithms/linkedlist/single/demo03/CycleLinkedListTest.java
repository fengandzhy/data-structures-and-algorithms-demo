package org.frank.structure.algorithms.linkedlist.single.demo03;

import org.frank.structure.algorithms.linkedlist.single.HeroNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CycleLinkedListTest {
    
    @Test
    public void testSize(){
        CycleLinkedList cycleLinkedList = new CycleLinkedList();
        
        assertEquals(0,cycleLinkedList.size());
        
        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用", "智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5,"关胜", "大刀");
        HeroNode node6 = new HeroNode(6,"林冲", "豹子头");
        HeroNode node7 = new HeroNode(7,"秦明", "霹雳火");
        HeroNode node8 = new HeroNode(8,"呼延灼", "双鞭");
        
        cycleLinkedList.add(node1);
        cycleLinkedList.add(node2);
        cycleLinkedList.add(node3);
        cycleLinkedList.add(node4);
        cycleLinkedList.add(node5);
        cycleLinkedList.add(node6);
        cycleLinkedList.add(node7);
        cycleLinkedList.add(node8);        
        
        HeroNode header = cycleLinkedList.getHeader();
        assertEquals("宋江", header.getName());
        assertEquals(8,cycleLinkedList.size());
    }
}
