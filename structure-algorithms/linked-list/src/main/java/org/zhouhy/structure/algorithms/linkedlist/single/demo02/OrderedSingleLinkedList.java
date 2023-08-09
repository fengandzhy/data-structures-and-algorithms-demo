package org.zhouhy.structure.algorithms.linkedlist.single.demo02;

import com.sun.istack.internal.NotNull;
import org.zhouhy.structure.algorithms.linkedlist.single.HeroNode;
import org.zhouhy.structure.algorithms.linkedlist.single.demo01.SingleLinkedList;

public class OrderedSingleLinkedList extends SingleLinkedList {    
    
    public void add(@NotNull HeroNode heroNode){
        HeroNode temp = header.getNext();
        HeroNode preNode = header;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.getNumber() > heroNode.getNumber()){
                preNode.setNext(heroNode);
                heroNode.setNext(temp);
            }else{
                temp.setNext(heroNode);
            }
            preNode = temp;
            temp = temp.getNext();
        }
    }    
}
