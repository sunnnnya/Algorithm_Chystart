package basic_knowledge.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @BelongsPackage: basic_knowledge.heap
 * @ClassName: HeapGreater
 * @Author: 丛虹羽
 * @Date: 2024/8/15 下午9:33
 * @Description: 手写加强堆结构
 *
 * 系统提供的堆无法做到的事情：
 *      （1）入堆的元素，如果参与排序的指标方法变化，系统提供的堆无法做到时间复杂度O(logN)调整！！都是O(N)的调整！！【先遍历找到对应的值，然后做heapinsert或者heapify操作】
 *      （2）系统提供的堆只能弹出堆顶，做不到自由删除任何一个堆中的元素，或者说无法在时间复杂度O(logN)内完成!一定会高于O(logN)
 *      （3）根本原因：无反向索引表
 *  系统的堆结构只知道：  0   ->  object1
 *  系统提供的堆不知道：  object1 -> 0， 此时如果修改了 object1 的内容，引起堆结构的变化，只能顺序索引，然后修改【效率差】
 *  [object1, object2, object3, object4,...]
 *      0        1        2         3
 */
public class HeapGreater<T> {

    /**
     * 堆结构数组；
     */
    private ArrayList<T> heap;
    /**
     * 堆的反向索引表 obj -> 0表示当前放在堆中的对象，放在heap数组中的哪个索引位置；
     */
    private HashMap<T, Integer> indexMap;
    /**
     * 堆的大小
     */
    private int heapSize;
    /**
     * 比较器
     */
    private Comparator<? super T> comparable;

    public HeapGreater(Comparator<T> c) {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        comparable = c;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.heapSize == 0;
    }

    /**
     * 返回堆中的元素个数
     *
     * @return
     */
    public int size() {
        return this.heapSize;
    }

    /**
     * 查看是否包含某个元素
     * 使用了反向索引表，直接查O（1），系统实现的不存在
     *
     * @param obj
     * @return
     */
    public boolean contains(T obj) {
        return this.indexMap.containsKey(obj);
    }

    /**
     * 添加元素到堆中
     *
     * @param obj
     */
    public void push(T obj) {
        heap.add(obj);
        indexMap.put(obj, heapSize);
        heapInsert(heapSize++);
    }

    /**
     * 直接返回堆顶元素，小根堆（最小值）、大根堆（最大值）
     *
     * @return
     */
    public T peek() {
        return this.heap.get(0);
    }

    /**
     * 删除堆顶元素
     *
     * @return
     */
    public T pop() {
        T ans = heap.get(0);
        swap(0, heapSize - 1);
        indexMap.remove(ans);
        heap.remove(--heapSize);
        heapify(0);
        return ans;
    }

    /**
     * 传统的heapinsert过程
     *
     * @param index
     */
    private void heapInsert(int index) {
        while(comparable.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 从上到下进行调整
     *
     * @param index
     */
    private void heapify(int index) {
        int left = index * 2 + 1;
        while(left < heapSize) {
            int best = left + 1 < heapSize && comparable.compare(heap.get(left + 1), heap.get(left)) < 0 ? (left + 1) : left;
            best = comparable.compare(heap.get(best), heap.get(index)) < 0 ? best : index;
            if (best == index) {
                break;
            }
            swap(best, index);
            index = best;
            left = index * 2 + 1;
        }
    }

    /**
     * 删除指定的对象
     *
     * @param obj
     */
    public void remove(T obj) {
        T replace = heap.get(heapSize - 1);
        int index = indexMap.get(obj);
        indexMap.remove(obj);
        heap.remove(--heapSize);
        if (obj != replace) {
            heap.set(index, replace);
            indexMap.put(replace, index);
            resign(replace);
        }
    }

    /**
     * 堆指定的节点进行调整
     *
     * @param obj
     */
    public void resign(T obj) {
        heapInsert(indexMap.get(obj));
        heapify(indexMap.get(obj));
    }

    /**
     * 获取所有的元素
     *
     * @return
     */
    public List<T> getAllElements() {
        List<T> ans = new ArrayList<>();
        for (T c : heap) {
            ans.add(c);
        }
        return ans;
    }

    /**
     * 交换堆中的两个索引位置的元素，同步更新反向索引表
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        T o1 = heap.get(i);
        T o2 = heap.get(j);
        // 堆上的元素，交换位置信息
        heap.set(i, o2);
        heap.set(j, o1);
        // 反向索引表同步更新
        indexMap.put(o2, i);
        indexMap.put(o1, j);
    }
}
