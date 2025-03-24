package leetcode.skill.array.common;

/**
 * @package: leetcode.skill.array.common
 * @author: chystart
 * @create: 2025-03-24 13:30
 * @description: 移除元素
 *
 * leetcode: https://leetcode.cn/problems/remove-element/
 **/
public class RemoveElement {

    /**
     * 定义指针变量
     *
     * @param nums 原始数组
     * @param val 要移除的值
     * @return 不等于的个数
     */
    public static int removeElement(int[] nums, int val) {
        int left = 0, ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                swap(nums, left++, i);
                ans++;
            }
        }
        return ans;
    }

    /**
     * 交换两个数
     *
     * @param arr 原始数组
     * @param i   i index
     * @param j   j index
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(arr, 3));
    }
}
