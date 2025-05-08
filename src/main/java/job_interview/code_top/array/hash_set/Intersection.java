package job_interview.code_top.array.hash_set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @BelongsPackage: job_interview.code_top.array
 * @ClassName: Intersection
 * @Author: 丛虹羽
 * @Date: 2025/5/8 16:19
 * @Description: 两个数组的交集
 * https://leetcode.cn/problems/intersection-of-two-arrays/description/
 */
public class Intersection {

    /**
     * 一次遍历，通过不断从 set 中提出元素进行条件判定
     *
     * @param nums1 原始数组1
     * @param nums2 原始数组2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> st = new HashSet<>();
        for(int num : nums1) {
            st.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for(int num : nums2) {
            if(st.contains(num)) {
                list.add(num);
                st.remove(num);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
