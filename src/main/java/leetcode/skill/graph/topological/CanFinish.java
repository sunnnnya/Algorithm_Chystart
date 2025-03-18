package leetcode.skill.graph.topological;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-18 15:07
 * @description: 课程表
 *
 * leetcode: https://leetcode.cn/problems/course-schedule/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class CanFinish {

    /**
     * 拓扑排序 + 邻接表
     *   课程表、食物链、都要往拓扑排序 + 邻接表靠
     *
     * @param numCourses    课程数量
     * @param prerequisites 前置课程条件
     * @return true | false
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> adjacency = new ArrayList<>();
        // 初始化邻接表
        for(int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // 遍历整个图，完成入度表初始化 + 连接表的构建
        for(int[] arr : prerequisites) {
            indegree[arr[0]]++;
            adjacency.get(arr[1]).add(arr[0]);
        }
        // 所有入度为 0 的点入队列
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        // 入度为 0 的点以此弹出队列，同时相连接的点的入度以此减少
        while(!queue.isEmpty()) {
            int x = queue.poll();
            numCourses--;
            for(int nextNode : adjacency.get(x)) {
                indegree[nextNode]--;
                if(indegree[nextNode] == 0) {
                    queue.add(nextNode);
                }
            }
        }
        return numCourses == 0;
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
