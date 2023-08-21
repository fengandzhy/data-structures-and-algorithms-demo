package org.frank.structure.algorithms.linkedlist.bidirectional.demo02;

import org.frank.structure.algorithms.linkedlist.bidirectional.HeroNode;
import org.frank.structure.algorithms.linkedlist.bidirectional.demo01.BiDirectionLinkedList;

public class OrderedBiDirectionLinkedList extends BiDirectionLinkedList {

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void add(HeroNode heroNode) {
        HeroNode temp = headNode;
        boolean isExist = false;
        while (temp.getNext() != null && temp.getNext().getNumber() <= heroNode.getNumber()) {
            if (temp.getNext().getNumber() == heroNode.getNumber()) {
                isExist = true;
                break;
            }
            temp = temp.getNext();
        }
        if (isExist) {
            throw new RuntimeException("The node has already existed.");
        }
        heroNode.setNext(temp.getNext());
        if(!temp.equals(headNode)){
            heroNode.setPre(temp);
        }
        temp.setNext(heroNode);
    }
}
