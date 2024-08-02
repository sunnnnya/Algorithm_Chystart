package practice_questions.kmp.easy;

/**
 * @BelongsPackage: practice_questions.kmp.easy
 * @ClassName: SameTree
 * @Author: 丛虹羽
 * @Date: 2024/8/2 下午5:00
 * @Description: 相同子树的判断
 *
 * 如何判定一个树时另一个树的子树
 *          右边的树 是 左边的树的子树
 *         5                  4
 *       |    \              |  \
 *      4      6            1    2
 *    |   \
 *   1     2
 *   层序遍历：5 4 6 1 2        4 1 2   （x）
 *   中序遍历：1 4 2 5 6        1 4 2   （√）包含 1 4 2
 *   先序遍历：5 4 1 2 6        4 1 2   （√）包含 4 1 2
 *   后序遍历：1 2 4 6 5        1 2 4   （√）包含 1 2 4
 *
 *          右边的树 不是 左边的树的子树
 *         5                  4
 *       |    \             |    \
 *      4      6           1      2
 *    |   \               |
 *   1     2             5
 *   层序遍历：5 4 6 1 2        4 1 2 5  （x）
 *   中序遍历：1 4 2 5 6        5 1 4 2  （x）
 *   先序遍历：5 4 1 2 6        4 1 5 2  （x）
 *   后序遍历：1 2 4 6 5        5 1 2 4  （x）
 */
public class SameTree {

    /**
     * 树的节点结构
     */
    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 获取树的中序遍历序列
     *
     * @param head
     */
    private static String getTreeString(TreeNode head) {
        if(head == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getTreeString(head.left));
        stringBuilder.append(head.value);
        stringBuilder.append(getTreeString(head.right));
        return stringBuilder.toString();
    }

    /**
     * 判断s2 是不是 s1 的字串 <=> s2 对应的子树是不是s1 的子树
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int kmp(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int x = 0;
        int y = 0;
        int[] next = getNextArray(str2);
        while (x < str1.length && y < str2.length) {
            if (str1[x] == str2[y]) {
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == str2.length ? x - y : -1;
    }

    /**
     * 求解 Kmp 中的 next 数组
     *
     * @param str
     * @return
     */
    public static int[] getNextArray(char[] str) {
        if(str.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int index = 2;
        int cn = 0;
        while (index < str.length) {
            if (str[index - 1] == str[cn]) {
                next[index++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 构建左树
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.left.left = treeNode4;
        treeNode1.left.right = treeNode5;
        treeNode1.right = treeNode3;
        // 构建左树并返回字符串
        String leftTreeString = getTreeString(treeNode1);
        System.out.println("leftTreeString = " + leftTreeString);
        // leftTreeString = 14256

        //  构建左树的子树
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(1);
        TreeNode treeNode8 = new TreeNode(2);
        treeNode6.left = treeNode7;
        treeNode6.right = treeNode8;
        String rightTreeString = getTreeString(treeNode6);
        System.out.println("rightTreeString = " + rightTreeString);
        // rightTreeString = 142

        // 构建不是左树的子树
        TreeNode treeNode9 = new TreeNode(4);
        TreeNode treeNode10 = new TreeNode(1);
        TreeNode treeNode11 = new TreeNode(2);
        TreeNode treeNode12 = new TreeNode(5);
        treeNode9.left = treeNode10;
        treeNode9.right = treeNode11;
        treeNode9.left.left = treeNode12;
        String rightTreeString2 = getTreeString(treeNode9);
        System.out.println("rightTreeString2 = " + rightTreeString2);
        // rightTreeString2 = 5142

        System.out.println(kmp(leftTreeString, rightTreeString) != -1 ? "右侧的树是左侧树的子树" : "右侧的树不是左侧树的子树");
        // 右侧的树是左侧树的子树
        System.out.println(kmp(leftTreeString, rightTreeString2) != -1 ? "右侧的树是左侧树的子树" : "右侧的树不是左侧树的子树");
        // 右侧的树不是左侧树的子树
    }
}
