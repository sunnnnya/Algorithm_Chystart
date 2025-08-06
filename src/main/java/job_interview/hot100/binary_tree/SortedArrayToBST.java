package job_interview.hot100.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @BelongsPackage: job_interview.hot100.binary_tree
 * @ClassName: SortedArrayToBST
 * @Author: 丛虹羽
 * @Date: 2025/7/16 11:30
 * @Description: 将有序数组转换为二叉搜索树
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SortedArrayToBST {

    /**
     * 二叉树结点
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 二叉树转换为二叉搜索树，因为本身就是有序的，所以直接转换
     *
     * @param nums 原始数组
     * @return TreeNode
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    /**
     * 进行结点的拼接
     *
     * @param nums 原始数组
     * @param left 左端点
     * @param right 右端点
     * @return TreeNode
     */
    private static TreeNode dfs(int[] nums, int left, int right) {
        if(left == right) {
            return new TreeNode(nums[left]);
        }
        if(left > right) {
            return null;
        }
        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode leftNode = dfs(nums, left, mid - 1);
        TreeNode rightNode = dfs(nums, mid + 1, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    /**
     * 二叉树的层级遍历
     *
     * @param root 二叉树的根节点
     * @return List<List<Integer>>
     */
    public static List<List<Integer>> levelTravel(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                root = queue.poll();
                list.add(root.val);
                if(root.left != null) {
                    queue.offer(root.left);
                }
                if(root.right != null) {
                    queue.offer(root.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] arr = new int[]{-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(arr);
        List<List<Integer>> lists = levelTravel(treeNode);
        System.out.println("lists = " + lists);
        // lists = [[0], [-10, 5], [-3, 9]]
    }
}
