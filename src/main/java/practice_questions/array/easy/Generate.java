package practice_questions.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: practice_questions.array.easy
 * @ClassName: Generate
 * @Author: 丛虹羽
 * @Date: 2024/8/15 上午8:59
 * @Description: 杨辉三角
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * leetcode: https://leetcode.cn/problems/pascals-triangle
 */
public class Generate {

    /**
     * 生成杨辉三角
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> row = new ArrayList<>(numRows);
        row.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> column = new ArrayList<>(i + 1);
            column.add(1);
            for (int j = 1; j < i; j++) {
                column.add(row.get(i - 1).get(j - 1) + row.get(i - 1).get(j));
            }
            column.add(1);
            row.add(column);
        }
        return row;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(generate(5));
        // [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
    }
}
