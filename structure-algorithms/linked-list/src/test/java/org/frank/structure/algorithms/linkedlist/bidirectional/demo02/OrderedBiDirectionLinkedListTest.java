package org.frank.structure.algorithms.linkedlist.bidirectional.demo02;


import org.frank.structure.algorithms.linkedlist.bidirectional.HeroNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderedBiDirectionLinkedListTest {

    @Test
    public void testAdd() {
        OrderedBiDirectionLinkedList orderedBiDirectionLinkedList = new OrderedBiDirectionLinkedList();

        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用", "智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5,"关胜", "大刀");
        HeroNode node6 = new HeroNode(6,"林冲", "豹子头");
        HeroNode node7 = new HeroNode(7,"秦明", "霹雳火");
        HeroNode node8 = new HeroNode(8,"呼延灼", "双鞭");

        orderedBiDirectionLinkedList.add(node5);
        orderedBiDirectionLinkedList.add(node7);
        orderedBiDirectionLinkedList.add(node8);
        orderedBiDirectionLinkedList.add(node2);
        orderedBiDirectionLinkedList.add(node3);

        orderedBiDirectionLinkedList.add(node4);
        orderedBiDirectionLinkedList.add(node6);
        orderedBiDirectionLinkedList.add(node1);

        HeroNode node = orderedBiDirectionLinkedList.get(0);
        assertEquals("宋江",node.getName());

        node = orderedBiDirectionLinkedList.get(7);
        assertEquals("呼延灼",node.getName());

        node = orderedBiDirectionLinkedList.getNodeByNumber(4);
        assertEquals("公孙胜",node.getName());
    }
}