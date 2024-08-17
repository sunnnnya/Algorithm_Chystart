package basic_knowledge.tree.binary_tree.middle;

import practice_questions.binary_tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree.hard
 * @ClassName: MaxSubBSTSize
 * @Author: 丛虹羽
 * @Date: 2024/8/17 下午8:33
 * @Description: 最大的子二叉搜索树的节点个数
 *
 *      现在有一棵树的结构如下：
 *                   5
 *                 /  \
 *               3     8
 *             /  \   /  \
 *            1    6 7    9
 *             \
 *              2
 *
 *  其中：     3                8    两棵树都是BST
 *          /  \             /  \
 *         1    6           7    9
 *          \
 *           2
 */
public class MaxSubBSTSize {

    /**
     * 信息体
     */
    public static class Info {
        // 以当前节点为头的包含的子树是BST的节点个数
        public int maxBSTSubTreeSize;
        // 以当前节点为头的子树有多少个节点
        public int allSize;
        // 左树的最大值
        public int max;
        // 右树的最小值
        public int min;

        public Info(int maxBSTSubTreeSize, int allSize, int max, int min) {
            this.maxBSTSubTreeSize = maxBSTSubTreeSize;
            this.allSize = allSize;
            this.max = max;
            this.min = min;
        }
    }

    /**
     * 递归函数
     *
     * @param root
     * @return
     */
    public static Info process(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int max = root.val;
        int min = root.val;
        int allSize = 1;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
            allSize += leftInfo.allSize;
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
            allSize += rightInfo.allSize;
        }
        int p1 = -1;
        if (leftInfo != null) {
            p1 = leftInfo.maxBSTSubTreeSize;
        }
        int p2 = -1;
        if (rightInfo != null) {
            p2 = rightInfo.maxBSTSubTreeSize;
        }
        int p3 = -1;
        boolean leftBST = leftInfo == null ? true : (leftInfo.maxBSTSubTreeSize == leftInfo.allSize);
        boolean rightBST = rightInfo == null ? true : (rightInfo.maxBSTSubTreeSize == rightInfo.allSize);
        if (leftBST && rightBST) {
            boolean leftMaxLessX = leftInfo == null ? true : leftInfo.max < root.val;
            boolean rightMinLessX = rightInfo == null ? true : rightInfo.min > root.val;
            if (leftMaxLessX && rightMinLessX) {
                int leftSize = leftInfo == null ? 0 : leftInfo.allSize;
                int rightSize = rightInfo == null ? 0 : rightInfo.allSize;
                p3 = leftSize + rightSize + 1;
            }
        }
        return new Info(Math.max(p1, Math.max(p2, p3)), allSize, max, min);
    }

    /**
     * 主函数
     *
     * @param root
     * @return
     */
    public static int maxSubBSTSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root).maxBSTSubTreeSize;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
