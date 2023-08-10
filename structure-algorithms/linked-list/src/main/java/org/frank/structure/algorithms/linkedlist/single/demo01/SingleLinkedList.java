package org.frank.structure.algorithms.linkedlist.single.demo01;

import com.sun.istack.internal.NotNull;
import org.frank.structure.algorithms.linkedlist.single.HeroNode;

public class SingleLinkedList {
    
    protected HeroNode header = new HeroNode(0,"", "");
    
    public void add(@NotNull HeroNode node){
        HeroNode temp = header;
        while (true) {            
            if(temp.getNext() == null){
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(node);
    }
    
    public void print(){
        HeroNode temp = header;
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
