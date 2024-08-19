package practice_questions.union_find.medium;

import basic_knowledge.union_find.UnionFind;

/**
 * @BelongsPackage: practice_questions.union_find.medium
 * @ClassName: FindCircleNum
 * @Author: 丛虹羽
 * @Date: 2024/8/19 下午9:16
 * @Description: 省份数量
 *
 * 有 n 个城市，其中一些彼此相连，另一些没有相连；
 *      如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份是一组直接或间接相连的城市，组内不含其他没有相连的城市；
 *      给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 *          而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 *
 */
public class FindCircleNum {

    /**
     * 并查集的使用
     *
     * @param isConnected
     * @return
     */
    public static int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.sets();
    }

    /**
     * 并查集的高效数据结构（笔试、面试使用）
     *      （1）parent[i]：
     *          parent[i] = k    表示i的父亲是k
     *      （2）size[i]：
     *          size[i] = k, 如果i是代表节点，size[i]才有意义(i所在的集合大小是多少)，否则无意义
     *      （3）
     *      （4）sets：
     *          一共有多少个集合
     */
    public static class UnionFind {
        private int[] parent;
        private int[] size;
        private int[] help;
        private int sets;

        public UnionFind(int N) {
            this.parent = new int[N];
            this.size = new int[N];
            this.help = new int[N];
            this.sets = N;
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        /**
         * 找到代表节点
         *
         * @param i
         * @return
         */
        private int find(int i) {
            int hi = 0;
            while (i != parent[i]) {
                help[hi++] = i;
                i = parent[i];
            }
            for (hi--; hi >=0; hi--) {
                parent[help[hi]] = i;
            }
            return i;
        }

        /**
         * 合并方法
         *
         * @param i
         * @param j
         */
        public void union(int i, int j) {
            int f1 = find(i);
            int f2 = find(j);
            if (f1 != f2) {
                if (size[f1] >= size[f2]) {
                    size[f1] += size[f2];
                    parent[f2] = f1;
                } else {
                    size[f2] += size[f1];
                    parent[f1] = f2;
                }
                sets--;
            }
        }

        /**
         * 返回集合个数
         *
         * @return
         */
        public int sets() {
            return sets;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(arr));
        //  3

        int[][] arr1 = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(arr1));
        // 2
    }
}
