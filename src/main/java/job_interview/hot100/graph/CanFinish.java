package job_interview.hot100.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: job_interview.hot100.graph
 * @ClassName: CanFinish
 * @Author: 丛虹羽
 * @Date: 2025/7/25 17:07
 * @Description: 课程表
 * https://leetcode.cn/problems/course-schedule/?envType=study-plan-v2&envId=top-100-liked
 */
public class CanFinish {

    private static int MAXN = 200001;

    private static int[] inDegree = new int[MAXN];

    private static int[] queue = new int[MAXN];

    private static int l, r = 0;

    /**
     * 拓扑排序
     *
     * @param numCourses 课程的数量
     * @param prerequisites 先修课程
     * @return boolean
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        clear();
        initGraph(graph, numCourses);
        for(int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        for(int i = 0; i <  numCourses; i++) {
            if(inDegree[i] == 0) {
                queue[r++] = i;
            }
        }
        while(l < r) {
            int num = queue[l++];
            numCourses--;
            for(int nextNode : graph.get(num)) {
                if(--inDegree[nextNode] == 0) {
                    queue[r++] = nextNode;
                }
            }
        }
        return numCourses == 0;
    }

    /**
     * 初始化链接表
     *
     * @param graph     邻接表
     * @param numCourse 课程的数量
     */
    private static void initGraph(List<List<Integer>> graph, int numCourse) {
        for(int i = 0; i < numCourse; i++) {
            graph.add(new ArrayList<>());
        }
    }

    /**
     * 清理工作
     */
    private static void clear() {
        l = r = 0;
        Arrays.fill(inDegree, 0);
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int numCourse = 2;
        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};
        System.out.println(canFinish(numCourse, prerequisites));
        // false

        int numCourseTwo = 2;
        int[][] prerequisitesTwo = new int[][]{{1, 0}};
        System.out.println(canFinish(numCourseTwo, prerequisitesTwo));
        // true
    }
}
