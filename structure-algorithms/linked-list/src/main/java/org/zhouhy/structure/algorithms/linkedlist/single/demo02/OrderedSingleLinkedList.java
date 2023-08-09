package org.zhouhy.structure.algorithms.linkedlist.single.demo02;

import com.sun.istack.internal.NotNull;
import org.zhouhy.structure.algorithms.linkedlist.single.HeroNode;
import org.zhouhy.structure.algorithms.linkedlist.single.demo01.SingleLinkedList;

public class OrderedSingleLinkedList extends SingleLinkedList {

    public void add(@NotNull HeroNode heroNode) {
        HeroNode temp = header.getNext();
        HeroNode preNode = header;
        while (true) {
            if (temp == null || temp.getNumber() > heroNode.getNumber()) {                                
                break;
            }            
            preNode = temp;
            temp = temp.getNext();                        
        }
        preNode.setNext(heroNode);
        heroNode.setNext(temp);
    }
}
