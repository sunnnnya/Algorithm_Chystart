package leetcode.hot100;

import java.util.*;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-18 15:07
 * @description: 课程表
 *
 * leetcode: https://leetcode.cn/problems/course-schedule/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class CanFinish {

    public static int MAXN = 20001;

    public static int[] queue = new int[MAXN];

    public static int[] indegree = new int[MAXN];

    public static int l = 0, r = 0;

    /**
     * 拓扑排序 + 邻接表
     *   课程表、食物链、都要往拓扑排序 + 邻接表靠
     *
     * @param numCourses    课程数量
     * @param prerequisites 前置课程条件
     * @return true | false
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        clear();
        List<List<Integer>> adjacency = new ArrayList<>();
        // 初始化邻接表
        initAdjacencyList(adjacency, numCourses);
        // 初始化入度表，填充邻接表的数据
        for(int[] a : prerequisites) {
            indegree[a[0]]++;
            adjacency.get(a[1]).add(a[0]);
        }
        // 入度为 0 的点进入队列中
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue[r++] = i;
            }
        }
        // 队列非空进行计算
        while(l < r) {
            int x = queue[l++];
            numCourses--;
            for(int nextNode : adjacency.get(x)) {
                if(--indegree[nextNode] == 0) {
                    queue[r++] = nextNode;
                }
            }
        }
        return numCourses == 0;
    }

    /**
     * 邻接表的初始化
     *
     * @param adjacency 邻接表
     */
    public static void initAdjacencyList(List<List<Integer>> adjacency, int numCourses) {
        for(int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
    }

    /**
     * 擦除数据
     */
    public static void clear() {
        l = 0;
        r = 0;
        Arrays.fill(indegree, 0);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 0}};
        System.out.println(canFinish(2, arr));
        // true

        int[][] arr1 = new int[][]{{1, 0}, {0, 1}};
        System.out.println(canFinish(2, arr1));
        // false
    }
}
