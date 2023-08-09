package org.zhouhy.structure.algorithms.linkedlist.single.demo02;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.zhouhy.structure.algorithms.linkedlist.single.HeroNode;
import org.zhouhy.structure.algorithms.linkedlist.single.demo01.SingleLinkedList;

/**
 * 有序的单向列表里加入元素, 首先要找到, 所加入元素的具体位置的前一个位置.
 */
public class OrderedSingleLinkedList extends SingleLinkedList {

    public void add(@NotNull HeroNode heroNode) {
        HeroNode temp = header;
        boolean isExist = false;
        while (true) {
            if (temp.getNext() == null || temp.getNext().getNumber() > heroNode.getNumber()) {
                break;
            }
            if (temp.getNext().getNumber() == heroNode.getNumber()) {
                isExist = true;
            }
            temp = temp.getNext();
        }
        if (isExist) {
            throw new RuntimeException("The node has already existed.");
        }
        heroNode.setNext(temp.getNext());
        temp.setNext(heroNode);
    }

    @Nullable
    public HeroNode get(int index) {
        int begin = -1; // 这里的begin 从 header 开始计算，而header不是链表中的值, 所以从-1开始计算
        HeroNode temp = header;
        while (true) {
            if (begin == index || temp.getNext() == null) {
                break;
            }
            begin++;
            temp = temp.getNext();
        }
        if (begin != index) {
            return null;
        }
        return temp;
    }
}
