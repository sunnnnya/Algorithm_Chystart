package list;

/**
 * @BelongsPackage: list
 * @ClassName: ImplementDequeUseArray
 * @Author: 丛虹羽
 * @Date: 2024/7/22 下午9:10
 * @Description: 使用数组实现双端队列 -> JDK中自带LinkedList<T>
 *
 * leetcode: https://leetcode.cn/problems/design-circular-deque/
 */
public class ImplementDequeUseArray {

    public static class MyCircleDeque {
        public int[] deque;
        public int l, r, size, limit;

        public MyCircleDeque(int k) {
            deque = new int[k];
            l = r = size = 0;
            limit = k; // k -> 表示双端队列存储元素不能超过 K 个
        }

        /**
         * 头部插入数据
         *
         * @param value
         * @return
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                } else {
                    l = l == 0 ? (limit - 1) : (l - 1);
                    deque[l] = value;
                }
                size++;
                // insert successfully
                return true;
            }
        }

        /**
         * 尾部插入数据
         *
         * @param value
         * @return
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                if(isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                } else {
                    r = (r == limit - 1) ? 0 : (r + 1);
                    deque[r] = value;
                }
                size++;
                return true;
            }
        }

        /**
         * 获取头部的双端队列的信息
         *
         * @return
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque[l];
            }
        }

        /**
         * 获取尾部的双端队列的信息
         *
         * @return
         */
        public int getLast() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque[r];
            }
        }

        /**
         * 获取头部的信息，并且删除
         *
         * @return
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                l = l == limit - 1 ? 0 : l + 1;
                size--;
                return true;
            }
        }

        /**
         * 获取头部的信息，并且删除
         * @return
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                r = r == 0 ? limit - 1 : r - 1;
                size--;
                return true;
            }
        }

        /**
         * 判断双端队列是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 判断双端队列满没满
         *
         * @return
         */
        public boolean isFull() {
            return size == limit;
        }

        /**
         * 获取双端队列中存储的值的多少
         *
         * @return
         */
        public int getSize() {
            return size;
        }
    }

    public static void main(String[] args) {
        MyCircleDeque deque = new MyCircleDeque(5);
        deque.insertFront(2);
        deque.insertFront(3);
        deque.insertLast(23);
        System.out.println(deque.getFront()); // 3
        System.out.println(deque.getLast()); // 23
        System.out.println(deque.deleteFront()); // true
        System.out.println(deque.getFront()); // 2
        System.out.println(deque.deleteLast()); // true
        System.out.println(deque.getLast()); // 2
        System.out.println(deque.isEmpty()); // false
        deque.insertLast(100);
        System.out.println(deque.getFront()); // 2
        System.out.println(deque.getLast()); // 100
        System.out.println(deque.getSize()); // 2
    }
}
