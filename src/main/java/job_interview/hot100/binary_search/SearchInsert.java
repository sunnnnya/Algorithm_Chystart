package job_interview.hot100.binary_search;

/**
 * @BelongsPackage: job_interview.hot100.binary_search
 * @ClassName: SearchInsert
 * @Author: 丛虹羽
 * @Date: 2025/7/16 21:45
 * @Description: 搜索插入位置
 * https://leetcode.cn/problems/search-insert-position/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SearchInsert {

    /**
     * 二分搜索拓展:
     *  >= target 最左位置
     *
     * @param nums 原始数组
     * @param target 目标值
     * @return int
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
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums, 2));
        // 1
    }
}
