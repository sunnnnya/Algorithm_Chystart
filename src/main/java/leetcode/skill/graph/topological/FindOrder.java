package leetcode.skill.graph.topological;

import java.util.*;

/**
 * @package: leetcode.skill.graph.topological
 * @author: chystart
 * @create: 2025-03-18 15:42
 * @description: 课程表 II
 *
 * leetcode: https://leetcode.cn/problems/course-schedule-ii/description/
 **/
public class FindOrder {

    /**
     * 拓扑排序 + 邻接表
     *
     * @param numCourses    课程数量
     * @param prerequisites 边信息
     * @return 原始数组
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] ans = new int[numCourses];
        int index = 0;
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        // 邻接表初始化
        for(int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // 入度表初始化，邻接表数据初始化
        for(int[] arr : prerequisites) {
            indegree[arr[0]]++;
            adjacency.get(arr[1]).add(arr[0]);
        }
        // 入度为 0 的入队列
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int node = queue.poll();
            ans[index++] = node;
            for(int next : adjacency.get(node)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return index == numCourses ? ans : new int[]{};
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
        //
    }
}
