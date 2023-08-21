package org.frank.structure.algorithms.linkedlist.bidirectional.demo01;

import org.frank.structure.algorithms.linkedlist.bidirectional.HeroNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BiDirectionLinkedListTest {

    @Test
    public void testAdd(){
        
        BiDirectionLinkedList biDirectionLinkedList = new BiDirectionLinkedList();
        
        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴勇", "智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5,"关胜", "大刀");

        biDirectionLinkedList.add(node1);
        biDirectionLinkedList.add(node2);
        biDirectionLinkedList.add(node3);
        biDirectionLinkedList.add(node4);
        biDirectionLinkedList.add(node5);

        assertEquals(5,biDirectionLinkedList.size());
        biDirectionLinkedList.print();
    }
}
