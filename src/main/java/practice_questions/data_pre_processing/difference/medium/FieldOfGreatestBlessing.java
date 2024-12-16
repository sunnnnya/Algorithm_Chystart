package practice_questions.data_pre_processing.difference.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.data_pre_processing.difference.medium
 * @ClassName: FieldOfGreatestBlessing
 * @Author: 丛虹羽
 * @Date: 2024/12/16 下午3:07
 * @Description: 最强祝福力场 - 离散化处理（通过将小数变成整数然后使用差分）
 *
 * 相当于整体扩大了一倍，规避掉小数，结构是不会变化的。
 * 理解：x * 2 - ((r / 2) * 2)
 *
 * 对应坐标：x左： x * 2 - r
 * 对应坐标：x右： x * 2 + r
 * 对应坐标：y上： y * 2 + r
 * 对应坐标：y下： y * 2 - r
 *
 * leetcode: https://leetcode.cn/problems/xepqZ5
 */
public class FieldOfGreatestBlessing {

    /**
     * 离散化处理，重点
     *
     * @param forceField 原始数组
     * @return
     */
    public static int fieldOfGreatestBlessing(int[][] forceField) {
        int n = forceField.length;
        long[] xs = new long[n << 1];
        long[] ys = new long[n << 1];
        for(int i = 0, k = 0, p = 0; i < n; i++) {
            long x = forceField[i][0];
            long y = forceField[i][1];
            long r = forceField[i][2];
            xs[k++] = (x << 1) - r;
            xs[k++] = (x << 1) + r;
            ys[p++] = (y << 1) - r;
            ys[p++] = (y << 1) + r;
        }
        int sizex = sort(xs);
        int sizey = sort(ys);
        int[][] diff = new int[sizex + 2][sizey + 2];
        for(int i = 0, a, b, c, d; i < n; i++) {
            long x = forceField[i][0];
            long y = forceField[i][1];
            long r = forceField[i][2];
            a = rank(xs, (x << 1) - r, sizex);
            b = rank(ys, (y << 1) - r, sizey);
            c = rank(xs, (x << 1) + r, sizex);
            d = rank(ys, (y << 1) + r, sizey);
            add(diff, a, b, c, d);
        }
        int ans = 0;
        for(int i = 1; i < diff.length; i++) {
            for (int j = 1; j < diff[0].length; j++) {
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
                ans = Math.max(ans, diff[i][j]);
            }
        }
        return ans;
    }

    /**
     * 对数组进行排序
     *
     * @param nums 原始数组
     * @return     返回数组排序且去重之后元素的个数
     */
    public static int sort(long[] nums) {
        Arrays.sort(nums);
        int size = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[size - 1]) {
                nums[size++] = nums[i];
            }
        }
        return size;
    }

    /**
     * 找到数组中指定元素的下标
     *
     * @param nums
     * @param v
     * @param size
     * @return
     */
    public static int rank(long[] nums, long v, int size) {
        int l = 0;
        int r = size - 1;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(nums[mid] >= v) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l + 1;
    }

    /**
     * 差分数据的常规操作
     *
     * @param nums 原始数组
     * @param a
     * @param b
     * @param c
     * @param d
     */
    public static void add(int[][] nums, int a, int b, int c, int d) {
        nums[c + 1][d + 1] += 1;
        nums[a][b] += 1;
        nums[a][d + 1] -= 1;
        nums[c + 1][b] -= 1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,0,1}, {1,0,1}};
        System.out.println(fieldOfGreatestBlessing(arr));
    }
}