package org.frank.structure.algorithms.linkedlist.bidirectional.demo01;

import org.frank.structure.algorithms.linkedlist.bidirectional.HeroNode;

public class BiDirectionLinkedList {
    
    protected HeroNode headNode = new HeroNode(0,"","");
    
    public void add(HeroNode heroNode){
        HeroNode tempNode = headNode;
        boolean isExist = false;
        while(true){
            if(tempNode.getNext() == null){
                break;
            }
            if (tempNode.getNext().getNumber() == heroNode.getNumber()) {
                isExist = true;
            }
            tempNode = tempNode.getNext();
        }
        if (isExist) {
            throw new RuntimeException("The node has already existed.");
        }
        tempNode.setNext(heroNode);
        if(!tempNode.equals(headNode)){
            heroNode.setPre(tempNode);
        }
    }
    
    public int size(){
        int size = 0;
        HeroNode tempNode = headNode;
        while(true) {
            if (tempNode.getNext() == null) {
                break;
            }
            tempNode = tempNode.getNext();
            size++;
        }
        return size;
    }

    public void print(){
        HeroNode temp = headNode;
        if(temp.getNext() == null){
            throw new RuntimeException("The linked list is empty.");
        }
        while(true){
            temp = temp.getNext();
            if(temp != null){
                System.out.println(temp.toString());
            }else{
                break;
            }
        }
    }
    
    
    
    
}
