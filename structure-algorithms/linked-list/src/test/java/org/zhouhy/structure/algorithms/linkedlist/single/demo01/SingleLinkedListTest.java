package org.zhouhy.structure.algorithms.linkedlist.single.demo01;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SingleLinkedListTest {

    private SingleLinkedList singleLinkedList;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Before
    public void setUp(){
        singleLinkedList = new SingleLinkedList();
        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴勇", "智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5,"关胜", "大刀");
        
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);
        singleLinkedList.add(node5);
    }

    @Test
    public void testPrintEmptyList1(){
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("The linked list is empty.");
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.print();
    }

    @Test(expected = RuntimeException.class)
    public void testPrintEmptyList2(){        
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.print();
    }
    
    @Test
    public void testPrint(){
        singleLinkedList.print();
    }
}
