package org.frank.structure.algorithms.linkedlist.single.demo03;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.frank.structure.algorithms.linkedlist.single.HeroNode;

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
    
    public int getBegin(HeroNode nextNode){
        int index = 1;
        HeroNode temp = header;
        while(true){
            if(temp.equals(nextNode)){
                break;
            }
            index++;
            temp = temp.getNext();
        }
        return index;
    }
    
    public void print(){
        for(int i=0;i<this.size();i++){
            System.out.printf("第%d个节点是%d\n", i+1,this.get(i).getNumber());
        }        
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

    /**
     * 取得当前节点, 以及它的下一个节点
     * remove 当前节点
     * 在remove当前节点后的链表里 得到下一个节点的位置
     *
     * */
    @SuppressWarnings("DuplicatedCode")
    public void josephusProblem(int begin, int times) {
        if (header == null || begin < 1 || begin > this.size()) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        if (this.size() == 1) {
            System.out.printf("最后留在圈中的编号%d \n", header.getNumber());
            return;
        }
        HeroNode currentNode = this.get(begin - 1);
        int previousIndex = begin - 2;
        if(previousIndex < 0){
            previousIndex = previousIndex + this.size();
        }
        HeroNode previousNode = this.get(previousIndex);
        for (int i = 1; i < times; i++) {
            currentNode = currentNode.getNext();
            previousNode = previousNode.getNext();
        }
        System.out.printf("英雄%d出圈\n", currentNode.getNumber());
        HeroNode nextNode = currentNode.getNext();

//        remove(currentNode);
        remove(currentNode, previousNode);
        josephusProblem(getBegin(nextNode), times);
    }
    //
    @SuppressWarnings("DuplicatedCode")
    public void josephusProblem2(int begin, int times) {
        if (header == null || begin < 1 || begin > this.size()) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        if (this.size() == 1) {
            System.out.printf("最后留在圈中的编号%d \n", header.getNumber());
            return;
        }

        HeroNode currentNode = this.get(begin - 1);
        for (int i = 1; i < times; i++) {
            currentNode = currentNode.getNext();
        }
        System.out.printf("小孩%d出圈\n", currentNode.getNumber());
        begin = calculateNextBegin(begin,times);
        remove(currentNode);
        josephusProblem2(begin, times);
    }

    /**
     * 计算下一个节点在删除当前节点后的循环列表里的index 
     * */
    private int calculateNextBegin(int begin, int times){
        int currentIndex = (begin+times)%this.size();
        if(currentIndex == 1){
            currentIndex = this.size(); // 例如有15个元素, 起始值是1,就是第一个元素, 然后往后数15个, 按理说能刚好数到最后一个元素, 但是(begin+times)%this.size()==1, 所以就改变
        }else{
            currentIndex = currentIndex -1; // 例如有15个元素, 起始值是1,就是第一个元素, 然后往后数3个 (begin+times)%this.size()==4, 所以 currentIndex = 3;
        }
        int nextIndex = (currentIndex + 1)%this.size(); // 当前元素再往后推一个于整个循环链表取余值
        if(nextIndex == 1){  // 如果这个余值是1, 那说明当前元素是最后一个元素, 它在下一个元素的后面, 所以它这里不需要减1
            return nextIndex;
        }
        if(nextIndex == 0){ // 如果这个余值是0, 说明当前元素是倒数第二个元素, 而其下一个元素是倒数第一个元素, 但是这里不能用余值, 因为是它是0, 所以只能用this.size();
            nextIndex = this.size();
        }
        return nextIndex -1; // 当前元素在下一个元素之前, 计算出来的nextIndex应该是下一个元素再当前元素下的位置, 例如计算出来是4, 那么就是说下一个元素在当前链表的位置是第4个元素, 由于要remove掉当前元素, 那么该元素在改动后的链表里的位置是3, 也就是第3个元素
    }

    public void remove(HeroNode current, HeroNode previousNode){
        if (current == header && this.size() == 1) {
            header = null;
        }
        if (current != null) {
            previousNode.setNext(current.getNext());
            if (current == header) {
                header = current.getNext();
            }
        }
    }
}
