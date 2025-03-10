package leetcode.skill.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @package: leetcode.skill.dequeue
 * @author: chystart
 * @create: 2025-03-10 21:19
 * @description: 设计循环双端队列 —— 直接使用 LinkList 双端队列进行实现
 *
 * leetcode: https://leetcode.cn/problems/design-circular-deque/description/
 **/
public class ImplementDequeWithDoubleList {

    public Deque<Integer> deque = new LinkedList<>();

    public int size;

    public int limit;

    /**
     * 链表的初始化
     *
     * @param k 元素的个数
     */
    public ImplementDequeWithDoubleList(int k) {
        size = 0;
        limit = k;
    }

    /**
     * 双端链表从头部插入
     *
     * @param value 插入的具体数值
     * @return true | false
     */
    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        } else {
            deque.offerFirst(value);
            size++;
            return true;
        }
    }

    /**
     * 双端链表从尾部插入
     *
     * @param value 插入的具体数值
     * @return true | false
     */
    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        } else {
            deque.offerLast(value);
            size++;
            return true;
        }
    }

    /**
     * 删除头部节点
     *
     * @return true | false
     */
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        } else {
            deque.pollFirst();
            size--;
            return true;
        }
    }

    /**
     * 删除尾部节点
     *
     * @return true | false
     */
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        } else {
            deque.pollLast();
            size--;
            return true;
        }
    }

    /**
     * 获取双端队列的头部元素
     *
     * @return int
     */
    public int getFront() {
        if(isEmpty()) {
            return -1;
        } else {
            return deque.peekFirst();
        }
    }

    /**
     * 获取双端队列的尾部元素
     *
     * @return int
     */
    public int getRear() {
        if(isEmpty()) {
            return -1;
        } else {
            return deque.peekLast();
        }
    }

    /**
     * 判断是否为 空
     *
     * @return true | false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断是否为满的
     *
     * @return true | false
     */
    public boolean isFull() {
        return size == limit;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ImplementDequeWithDoubleList deque = new ImplementDequeWithDoubleList(3);
        System.out.println("insertLast(1): " + deque.insertLast(1));
        System.out.println("insertLast(2): " + deque.insertLast(2));
        System.out.println("insertFront(3): " + deque.insertFront(3));
        System.out.println("insertFront(4): " + deque.insertFront(4));
        System.out.println("rear: " + deque.getRear());
        System.out.println("isFull: " + deque.isFull());
        System.out.println("deleteLast(): " + deque.deleteLast());
        System.out.println("insertFront(): " + deque.insertFront(4));
        System.out.println("getFront(): " + deque.getFront());
    }
}
