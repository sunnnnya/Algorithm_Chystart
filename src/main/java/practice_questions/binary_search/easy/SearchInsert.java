package practice_questions.binary_search.easy;

/**
 * @BelongsPackage: practice_questions.binary_search.easy
 * @ClassName: SearchInsert
 * @Author: 丛虹羽
 * @Date: 2024/12/10 下午1:25
 * @Description: 搜索插入位置
 *
 * leetcode: https://leetcode.cn/problems/search-insert-position
 */
public class SearchInsert {

    /**
     * 二分搜索基本模板 >= num 的最左位置
     *
     * @param nums   原始数组
     * @param target 目标值
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
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
        int[] arr = new int[]{1,3,5,6};
        System.out.println(searchInsert(arr, 5));
    }
}