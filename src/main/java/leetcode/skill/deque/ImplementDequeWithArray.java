package leetcode.skill.deque;

/**
 * @package: leetcode.skill.deque
 * @author: chystart
 * @create: 2025-03-10 21:44
 * @description: 循环双端队列 —— 使用数组实现双端队列
 *
 * bilibili：https://www.bilibili.com/video/BV1PM4y1p7N5/?spm_id_from=333.1387.upload.video_card.click&vd_source=9eeeab41783c1ac3e2c0bb2c5060f976
 * leetcode: https://leetcode.cn/problems/design-circular-deque/
 **/
public class ImplementDequeWithArray {

    public static class MyCircularDeque {

        public int[] deque; // double end queue

        public int l, r, size, limit;

        public MyCircularDeque(int k) {
            deque = new int[k];
            l = r = size = 0;
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
                if(isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                } else {
                    l = l == 0 ? limit - 1 : l - 1;
                    deque[l] = value;
                }
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
                if(isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                } else {
                    r = r == limit - 1 ? 0 : r + 1;
                    deque[r] = value;
                }
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
            if (isEmpty())  {
                return false;
            } else {
                l = l == limit - 1 ? 0 : l + 1;
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
                r = r == 0 ? limit - 1 : r - 1;
                size--;
                return true;
            }
        }

        /**
         * 获取链表头部元素
         *
         * @return int
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque[l];
            }
        }

        /**
         * 获取链表尾部元素
         *
         * @return int
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque[r];
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
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);
        System.out.println("insertLast(1): " + deque.insertLast(1));
        System.out.println("insertLast(2): " + deque.insertLast(2));
        System.out.println("insertFront(3): " + deque.insertFront(3));
        System.out.println("insertFront(4): " + deque.insertFront(4));
        System.out.println("rear: " + deque.getRear());
        System.out.println("isFull: " + deque.isFull());
        System.out.println("deleteLast(): " + deque.deleteLast());
        System.out.println("insertFront(4): " + deque.insertFront(4));
        System.out.println("getFront(): " + deque.getFront());
    }
}
