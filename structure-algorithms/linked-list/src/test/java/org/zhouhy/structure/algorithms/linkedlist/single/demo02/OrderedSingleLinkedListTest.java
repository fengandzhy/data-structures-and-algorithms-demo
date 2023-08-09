package org.zhouhy.structure.algorithms.linkedlist.single.demo02;

import org.junit.Test;
import org.zhouhy.structure.algorithms.linkedlist.single.HeroNode;

public class OrderedSingleLinkedListTest {
    
    @Test
    public void testPrint(){
        OrderedSingleLinkedList orderedSingleLinkedList = new OrderedSingleLinkedList();
        
        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴勇", "智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5,"关胜", "大刀");

        orderedSingleLinkedList.add(node5);
        orderedSingleLinkedList.add(node4);
        orderedSingleLinkedList.add(node3);
        orderedSingleLinkedList.add(node2);
        orderedSingleLinkedList.add(node1);
        
        orderedSingleLinkedList.print();
    }
}
