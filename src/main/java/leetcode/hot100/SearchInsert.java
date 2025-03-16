package leetcode.hot100;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-16 21:33
 * @description: 搜索插入位置
 *
 * leetcode: https://leetcode.cn/problems/search-insert-position/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class SearchInsert {

    /**
     * 二分搜索
     *
     * @param nums   原始数组
     * @param target 目标值
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(arr, 5));
        // 2
    }
}
