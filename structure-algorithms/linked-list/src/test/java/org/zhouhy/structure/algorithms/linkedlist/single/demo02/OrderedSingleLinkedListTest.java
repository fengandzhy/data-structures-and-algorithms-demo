package org.zhouhy.structure.algorithms.linkedlist.single.demo02;

import org.junit.Assert;
import org.junit.Test;
import org.zhouhy.structure.algorithms.linkedlist.single.HeroNode;

import static org.junit.Assert.*;

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
    
    @Test
    public void testGet(){
        OrderedSingleLinkedList orderedSingleLinkedList = new OrderedSingleLinkedList();

        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用", "智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5,"关胜", "大刀");
        HeroNode node6 = new HeroNode(6,"林冲", "豹子头");
        HeroNode node7 = new HeroNode(7,"秦明", "霹雳火");
        HeroNode node8 = new HeroNode(8,"呼延灼", "双鞭");

        orderedSingleLinkedList.add(node5);
        orderedSingleLinkedList.add(node7);
        orderedSingleLinkedList.add(node8);
        orderedSingleLinkedList.add(node2);
        orderedSingleLinkedList.add(node3);

        orderedSingleLinkedList.add(node4);
        orderedSingleLinkedList.add(node6);
        orderedSingleLinkedList.add(node1);
        
        assertNull(orderedSingleLinkedList.get(8));
        assertEquals("呼延灼",orderedSingleLinkedList.get(7).getName());
        assertEquals("关胜",orderedSingleLinkedList.get(4).getName());
    }

    @Test
    public void testExists(){
        OrderedSingleLinkedList orderedSingleLinkedList = new OrderedSingleLinkedList();

        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(1,"宋江", "及时雨");
        orderedSingleLinkedList.add(node1);

        RuntimeException runtimeException = Assert.assertThrows(RuntimeException.class ,()-> orderedSingleLinkedList.add(node2));
        assertTrue(runtimeException.getMessage().contains("The node has already existed."));

    }
    
    @Test
    public void testGetNodeByNumber(){
        OrderedSingleLinkedList orderedSingleLinkedList = new OrderedSingleLinkedList();

        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用", "智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5,"关胜", "大刀");
        HeroNode node6 = new HeroNode(6,"林冲", "豹子头");
        HeroNode node7 = new HeroNode(7,"秦明", "霹雳火");
        HeroNode node8 = new HeroNode(8,"呼延灼", "双鞭");

        orderedSingleLinkedList.add(node5);
        orderedSingleLinkedList.add(node7);
        orderedSingleLinkedList.add(node8);
        orderedSingleLinkedList.add(node2);
        orderedSingleLinkedList.add(node3);

        orderedSingleLinkedList.add(node4);
        orderedSingleLinkedList.add(node6);
        orderedSingleLinkedList.add(node1);

        assertEquals("呼延灼",orderedSingleLinkedList.getNodeByNumber(8).getName());
        assertEquals("林冲",orderedSingleLinkedList.getNodeByNumber(6).getName());
    }
    
    @Test
    public void testDeleteByNumber(){
        OrderedSingleLinkedList orderedSingleLinkedList = new OrderedSingleLinkedList();

        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用", "智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5,"关胜", "大刀");
        HeroNode node6 = new HeroNode(6,"林冲", "豹子头");
        HeroNode node7 = new HeroNode(7,"秦明", "霹雳火");
        HeroNode node8 = new HeroNode(8,"呼延灼", "双鞭");
        HeroNode node9 = new HeroNode(9,"花荣", "小李广");
        HeroNode node10 = new HeroNode(10,"柴进", "小旋风");

        orderedSingleLinkedList.add(node1);
        orderedSingleLinkedList.add(node2);
        orderedSingleLinkedList.add(node3);
        orderedSingleLinkedList.add(node4);
        orderedSingleLinkedList.add(node5);
        orderedSingleLinkedList.add(node6);
        orderedSingleLinkedList.add(node7);
        orderedSingleLinkedList.add(node8);
        orderedSingleLinkedList.add(node9);
        orderedSingleLinkedList.add(node10);
        
        assertEquals(10, orderedSingleLinkedList.size());        
        orderedSingleLinkedList.deleteByNumber(10);
        assertEquals(9, orderedSingleLinkedList.size());
        assertEquals("呼延灼",orderedSingleLinkedList.getNodeByNumber(8).getName());
        orderedSingleLinkedList.deleteByNumber(7);
        assertEquals("关胜",orderedSingleLinkedList.getNodeByNumber(5).getName());
        assertEquals(8, orderedSingleLinkedList.size());
    }

    /**
     * 新浪面试题, 查找一个链表的倒数第几个元素
     * */
    @Test
    public void testGetNodeByLastNumber(){
        OrderedSingleLinkedList orderedSingleLinkedList = new OrderedSingleLinkedList();
        try {
            orderedSingleLinkedList.getNodeByLastNumber(0);
        } catch (Exception ex) {
            assertTrue(ex.getMessage().contains("Invalid input."));
        }

        try {
            orderedSingleLinkedList.getNodeByLastNumber(1);
        } catch (Exception ex) {
            assertTrue(ex.getMessage().contains("Out of the List size."));
        }
        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用", "智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5,"关胜", "大刀");
        orderedSingleLinkedList.add(node1);
        orderedSingleLinkedList.add(node2);
        orderedSingleLinkedList.add(node3);
        orderedSingleLinkedList.add(node4);
        orderedSingleLinkedList.add(node5);

        assertEquals("关胜",orderedSingleLinkedList.getNodeByLastNumber(1).getName());
        assertEquals("吴用",orderedSingleLinkedList.getNodeByLastNumber(3).getName());

        try {
            orderedSingleLinkedList.getNodeByLastNumber(6);
        } catch (Exception ex) {
            assertTrue(ex.getMessage().contains("Out of the List size."));
        }
    }

    /**
     * 单向链表腾讯面试题, 把一个单向链表反转一下
     * */
    @Test
    public void testReverse(){
        OrderedSingleLinkedList orderedSingleLinkedList = new OrderedSingleLinkedList();

        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用", "智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5,"关胜", "大刀");
        HeroNode node6 = new HeroNode(6,"林冲", "豹子头");
        HeroNode node7 = new HeroNode(7,"秦明", "霹雳火");
        HeroNode node8 = new HeroNode(8,"呼延灼", "双鞭");
        HeroNode node9 = new HeroNode(9,"花荣", "小李广");
        HeroNode node10 = new HeroNode(10,"柴进", "小旋风");

        orderedSingleLinkedList.add(node1);
        orderedSingleLinkedList.add(node2);
        orderedSingleLinkedList.add(node3);
        orderedSingleLinkedList.add(node4);
        orderedSingleLinkedList.add(node5);
        orderedSingleLinkedList.add(node6);
        orderedSingleLinkedList.add(node7);
        orderedSingleLinkedList.add(node8);
        orderedSingleLinkedList.add(node9);
        orderedSingleLinkedList.add(node10);

        assertEquals("柴进",orderedSingleLinkedList.getNodeByLastNumber(1).getName());
        assertEquals("花荣",orderedSingleLinkedList.getNodeByLastNumber(2).getName());
        
        orderedSingleLinkedList.reverse();

        assertEquals("宋江",orderedSingleLinkedList.getNodeByLastNumber(1).getName());
        assertEquals("卢俊义",orderedSingleLinkedList.getNodeByLastNumber(2).getName());
        
        orderedSingleLinkedList.print();
    }

    /**
     * 单向链表百度面试题, 反向打印单向列表
     * */
    @Test
    public void testPrintFromEnd(){
        OrderedSingleLinkedList orderedSingleLinkedList = new OrderedSingleLinkedList();

        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用", "智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5,"关胜", "大刀");
        HeroNode node6 = new HeroNode(6,"林冲", "豹子头");
        HeroNode node7 = new HeroNode(7,"秦明", "霹雳火");
        HeroNode node8 = new HeroNode(8,"呼延灼", "双鞭");
        HeroNode node9 = new HeroNode(9,"花荣", "小李广");
        HeroNode node10 = new HeroNode(10,"柴进", "小旋风");

        orderedSingleLinkedList.add(node1);
        orderedSingleLinkedList.add(node2);
        orderedSingleLinkedList.add(node3);
        orderedSingleLinkedList.add(node4);
        orderedSingleLinkedList.add(node5);
        orderedSingleLinkedList.add(node6);
        orderedSingleLinkedList.add(node7);
        orderedSingleLinkedList.add(node8);
        orderedSingleLinkedList.add(node9);
        orderedSingleLinkedList.add(node10);
        
        orderedSingleLinkedList.printFromEnd();
    }
    
    @Test
    public void testMergeTwoOrderedSingleLinkedList(){
        OrderedSingleLinkedList orderedSingleLinkedList1 = new OrderedSingleLinkedList();
        OrderedSingleLinkedList orderedSingleLinkedList2 = new OrderedSingleLinkedList();

        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用", "智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5,"关胜", "大刀");
        HeroNode node6 = new HeroNode(6,"林冲", "豹子头");
        HeroNode node7 = new HeroNode(7,"秦明", "霹雳火");
        HeroNode node8 = new HeroNode(8,"呼延灼", "双鞭");
        HeroNode node9 = new HeroNode(9,"花荣", "小李广");
        HeroNode node10 = new HeroNode(10,"柴进", "小旋风");

        orderedSingleLinkedList1.add(node1);
        orderedSingleLinkedList1.add(node3);
        orderedSingleLinkedList1.add(node5);
        orderedSingleLinkedList1.add(node7);
        orderedSingleLinkedList1.add(node9);

        orderedSingleLinkedList2.add(node2);
        orderedSingleLinkedList2.add(node4);
        orderedSingleLinkedList2.add(node6);
        orderedSingleLinkedList2.add(node8);
        orderedSingleLinkedList2.add(node10);
        
        orderedSingleLinkedList1.mergeTwoOrderedSingleLinkedList(orderedSingleLinkedList2);

        assertEquals("柴进",orderedSingleLinkedList1.getNodeByLastNumber(1).getName());
        assertEquals("花荣",orderedSingleLinkedList1.getNodeByLastNumber(2).getName());

        assertEquals("宋江",orderedSingleLinkedList1.get(0).getName());
        assertEquals("卢俊义",orderedSingleLinkedList1.get(1).getName());
        
        orderedSingleLinkedList1.print();
    }
}
