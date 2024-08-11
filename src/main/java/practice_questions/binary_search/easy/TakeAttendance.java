package practice_questions.binary_search.easy;

/**
 * @BelongsPackage: practice_questions.binary_search
 * @ClassName: TakeAttendance
 * @Author: 丛虹羽
 * @Date: 2024/7/30 上午12:14
 * @Description: 点名
 * 想法：
 *      找到可以二分的规律（按照下标的值，和records[i]进行比较），然后一次砍一半O(logN)
 *
 * 某班级 n 位同学的学号为 0 ~ n-1。点名结果记录于升序数组 records。假定仅有一位同学缺席，请返回他的学号。
 */
public class TakeAttendance {

    /**
     * 使用二分法找到缺席的数
     *
     * @param records
     * @return
     */
    public static int takeAttendance(int[] records) {
        int l = 0;
        int r = records.length - 1;
        while (l <= r) {
            int mid = r + ((l - r) >> 1);
            if (mid == records[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 8};
        System.out.println(takeAttendance(arr));
        // 7
    }
}
