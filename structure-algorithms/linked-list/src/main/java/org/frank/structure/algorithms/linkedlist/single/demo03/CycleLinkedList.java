package org.frank.structure.algorithms.linkedlist.single.demo03;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.frank.structure.algorithms.linkedlist.single.HeroNode;

import java.util.List;

public class CycleLinkedList {

    private HeroNode header = null;

    public void add(HeroNode node) {
        if (header == null) {
            header = node;
            node.setNext(header);
            return;
        }
        HeroNode currentNode = header;
        while (!currentNode.getNext().equals(header)) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(node);
        node.setNext(header);
    }

    public void add(int number) {
        for (int i = 1; i <= number; i++) {
            HeroNode heroNode = new HeroNode(i);
            this.add(heroNode);
        }
    }

    public void josephusProblem(int begin, int times, List<HeroNode> list) {
        if (header == null || begin < 1 || begin > this.size()) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        if (this.size() == 1) {
            System.out.printf("最后留在圈中的编号%d \n", header.getNumber());
            return;
        }
        print();
        System.out.println("当前节点是:"+begin);
        HeroNode currentNode = this.get(begin - 1);
        for (int i = 1; i < times; i++) {
            currentNode = currentNode.getNext();
            begin++;
            if (begin >= this.size()) {
                begin = 1;
            }
        }
        System.out.printf("小孩%d出圈\n", currentNode.getNumber());
        list.add(currentNode);
        remove(currentNode);
        josephusProblem(begin, times, list);
    }
    
    public void print(){
        for(int i=0;i<this.size();i++){
            System.out.printf("第%d个节点是%d\n", i+1,this.get(i).getNumber());
        }
        System.out.println("******************************************");
    }

    public int size() {
        int size = 0;
        HeroNode currentNode = header;
        if (currentNode == null) {
            return size;
        }
        while (true) {
            size++;
            if (currentNode.getNext().equals(header)) {
                break;
            }
            currentNode = currentNode.getNext();
        }
        return size;
    }

    @Nullable
    public HeroNode get(int index) {
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
    public HeroNode getPreNode(@NotNull HeroNode current) {
        HeroNode tempNode = header;
        while (!tempNode.getNext().equals(current)) {
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }

    public void remove(int index) {
        HeroNode current = this.get(index);
        this.remove(current);
    }

    public void remove(HeroNode current) {
        if (current == header && this.size() == 1) {
            header = null;
        }
        if (current != null) {
            HeroNode preNode = this.getPreNode(current);
            preNode.setNext(current.getNext());
            if (current == header) {
                header = current.getNext();
            }
        }
    }


    @NotNull
    public HeroNode getLast() {
        HeroNode current = header;
        while (!current.getNext().equals(header)) {
            current = current.getNext();
        }
        return current;
    }

    public HeroNode getHeader() {
        return header;
    }
}
