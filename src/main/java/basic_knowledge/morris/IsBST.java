package basic_knowledge.morris;

/**
 * @BelongsPackage: basic_knowledge.morris
 * @ClassName: IsBST
 * @Author: 丛虹羽
 * @Date: 2024/8/4 上午12:33
 * @Description: 使用Morris判断是否是搜索二叉搜索树
 */
public class IsBST {

    /**
     * 二叉树的节点信息
     */
    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static boolean isBST(TreeNode head) {
        if (head == null) {
            return false;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        Integer pre = null;
        boolean ans = true;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                // 自己左树的最右孩子，直到是 mostRight.right == null 或者 mostRight.right == cur都是不满足的条件
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            // 不要出现了，不满足的情况直接返回，应该遍历完整个树之后再返回，否则会出现问题（指针会出现改变指向的情况）
            if (pre != null && pre >= cur.value) {
                ans = false;
            }
            pre = cur.value;
            cur = cur.right;
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(12);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(11);
        TreeNode treeNode7 = new TreeNode(14);
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        System.out.println(isBST(treeNode1));
        // true

        TreeNode treeNode9 = new TreeNode(10);
        TreeNode treeNode10 = new TreeNode(21);
        TreeNode treeNode11 = new TreeNode(12);
        TreeNode treeNode12 = new TreeNode(3);
        TreeNode treeNode13 = new TreeNode(6);
        TreeNode treeNode14 = new TreeNode(11);
        TreeNode treeNode15 = new TreeNode(14);
        treeNode9.left = treeNode10;
        treeNode10.left = treeNode12;
        treeNode10.right = treeNode13;
        treeNode9.right = treeNode11;
        treeNode11.left = treeNode14;
        treeNode11.right = treeNode15;
        System.out.println(isBST(treeNode9));
    }
}
