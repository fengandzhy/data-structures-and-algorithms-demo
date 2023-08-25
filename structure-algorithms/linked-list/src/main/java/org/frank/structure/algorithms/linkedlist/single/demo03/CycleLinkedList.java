package org.frank.structure.algorithms.linkedlist.single.demo03;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.frank.structure.algorithms.linkedlist.single.HeroNode;

public class CycleLinkedList {

    private HeroNode header = null;
    
    public void add(HeroNode node){
        if(header == null){
            header = node;
            node.setNext(header);
            return;
        }
        HeroNode currentNode = header;
        while(!currentNode.getNext().equals(header)){
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(node);
        node.setNext(header);
    }
    
    public int size(){
        int size = 0;
        HeroNode currentNode = header;
        if(currentNode == null){
            return size;
        }
        while(!currentNode.getNext().equals(header)){
            currentNode = currentNode.getNext();
            size ++;
        }
        return size;
    }
    
    @Nullable
    public HeroNode get(int index){
        if (index < 0) {
            throw new RuntimeException("Invalid input.");
        }
        int begin = 0;
        HeroNode currentNode = header;
        while (begin != index && !currentNode.getNext().equals(header)) {
            begin++;
            currentNode = currentNode.getNext();
        }
        if (begin != index) {
            return null;
        }
        return currentNode;
    }
    
    @NotNull
    public HeroNode getPreNode(@NotNull HeroNode current){
        HeroNode tempNode = header;
        while(!tempNode.getNext().equals(current)){
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }

    public void remove(int index){
        HeroNode current = this.get(index);
        if(current == header && this.size() == 1){
            header = null;
        }
        if(current != null){
            HeroNode preNode = this.getPreNode(current);
            preNode.setNext(current.getNext());
            if(current == header){
                header = current.getNext();
            }
        }
    }
    
    
    
}
