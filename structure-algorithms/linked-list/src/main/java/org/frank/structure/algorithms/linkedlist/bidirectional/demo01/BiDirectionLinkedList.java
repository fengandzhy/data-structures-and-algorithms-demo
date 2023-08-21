package org.frank.structure.algorithms.linkedlist.bidirectional.demo01;

import org.frank.structure.algorithms.linkedlist.bidirectional.HeroNode;

public class BiDirectionLinkedList {
    
    protected HeroNode headNode = new HeroNode(0,"","");
    
    public void add(HeroNode heroNode){
        HeroNode tempNode = headNode;
        boolean isExist = false;
        while (tempNode.getNext() != null) {
            if (tempNode.getNext().getNumber() == heroNode.getNumber()) {
                isExist = true;
                break;
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
        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
            size++;
        }
        return size;
    }

    @SuppressWarnings("DuplicatedCode")
    public void print(){
        HeroNode temp = headNode;
        if(temp.getNext() == null){
            throw new RuntimeException("The linked list is empty.");
        }
        while(true){
            temp = temp.getNext();
            if(temp != null){
                System.out.println(temp);
            }else{
                break;
            }
        }
    }
    
    @SuppressWarnings("DuplicatedCode")
    public HeroNode get(int index){
        if (index < 0 || index > size()-1) {
            throw new RuntimeException("Invalid input.");
        }
        int start = -1; 
        HeroNode temp = headNode;
        while (start != index && temp.getNext() != null) {
            start++;
            temp = temp.getNext();
        }
        if (start != index) {
            return null;
        }
        return temp;        
    }

    @SuppressWarnings("DuplicatedCode")
    public HeroNode getNodeByNumber(int number) {
        HeroNode temp = headNode;
        boolean isExist = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
            if (temp.getNumber() == number) {
                isExist = true;
                break;
            }
        }
        if (isExist) {
            return temp;
        }
        return null;
    }

    public void deleteByNumber(int number) {
        HeroNode heroNode = getNodeByNumber(number);
        if(heroNode == null){
            throw new RuntimeException("No such element.");
        }
        HeroNode preNode = heroNode.getPre();
        HeroNode nextNode = heroNode.getNext();
        nextNode.setPre(preNode);
        preNode.setNext(nextNode);       
    }
}
