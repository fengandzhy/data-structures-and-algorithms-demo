package org.frank.structure.algorithms.linkedlist.single.demo02;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.frank.structure.algorithms.linkedlist.single.HeroNode;
import org.frank.structure.algorithms.linkedlist.single.demo01.SingleLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 有序的单向列表里加入元素, 首先要找到, 所加入元素的具体位置的前一个位置.
 */
public class OrderedSingleLinkedList extends SingleLinkedList {

    public void add(@NotNull HeroNode heroNode) {
        HeroNode temp = header;
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
        temp.setNext(heroNode);
    }

    @SuppressWarnings("DuplicatedCode")
    @Nullable
    public HeroNode get(int index) {
        if (index < 0) {
            throw new RuntimeException("Invalid input.");
        }
        int begin = -1; // 这里的begin 从 header 开始计算，而header不是链表中的值, 所以从-1开始计算
        HeroNode temp = header;
        while (begin != index && temp.getNext() != null) {
            begin++;
            temp = temp.getNext();
        }
        if (begin != index) {
            return null;
        }
        return temp;
    }

    public HeroNode getNodeByNumber(int number) {
        HeroNode temp = header;
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
        HeroNode temp = header;
        boolean isExist = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNumber() == number) {
                isExist = true;
                break;
            }
            temp = temp.getNext();
        }
        if (isExist) {
            temp.setNext(temp.getNext().getNext());
        } else {
            throw new RuntimeException("No such node.");
        }
    }

    public int size() {
        HeroNode temp = header;
        int size = 0;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            size++;
        }
        return size;
    }

    @NotNull
    public HeroNode getNodeByLastNumber(int number) {
        if (number <= 0) {
            throw new RuntimeException("Invalid input.");
        }
        int size = this.size();
        int index = size - number;
        if (index <= 0) {
            throw new RuntimeException("Out of the List size.");
        }
        return this.get(index);
    }

    public void reverse() {
        int length = this.size();
        if (length <= 0) {
            return;
        }
        HeroNode[] nodeArray = new HeroNode[length];
        HeroNode temp = header;
        int index = length - 1;
        while (true) {
            if (temp.getNext() != null) {
                nodeArray[index] = temp.getNext();
                temp = temp.getNext();
                index--;
            } else {
                break;
            }
        }
        header.setNext(null); // 要把头节点设成null, 重置头节点
        for (HeroNode node : nodeArray) {
            node.setNext(null); // 注意这里要把每一个节点的下一节点都设成null
            super.add(node);
        }
    }

    public void printFromEnd() {
        int length = this.size();
        if (length <= 0) {
            return;
        }
        List<HeroNode> nodeList = new ArrayList<>();
        HeroNode temp = header;
        while (temp.getNext() != null) {
            nodeList.add(temp.getNext());
            temp = temp.getNext();
        }
        for (int i = nodeList.size() - 1; i > -1; i--) {
            System.out.println(nodeList.get(i));
        }
    }
    
    public void mergeTwoOrderedSingleLinkedList(@NotNull OrderedSingleLinkedList orderedSingleLinkedList){
        int length = orderedSingleLinkedList.size();
        List<HeroNode> nodeList = new ArrayList<>();
        for(int i=0; i<length;i++){
            nodeList.add(orderedSingleLinkedList.get(i));
        }
        for(HeroNode node: nodeList){
            node.setNext(null);
            this.add(node);
        }
    }
}
