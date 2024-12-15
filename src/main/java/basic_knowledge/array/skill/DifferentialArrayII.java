package basic_knowledge.array.skill;

/**
 * @BelongsPackage: basic_knowledge.array.skill
 * @ClassName: Differential
 * @Author: 丛虹羽
 * @Date: 2024/12/15 下午9:20
 * @Description: 二维差分
 */
public class DifferentialArrayII {

    /**
     * 扩充一圈的 0
     *
     * @param arr 原始数组
     * @return
     */
    public static int[][] changeArray(int[][] arr) {
        int[][] a = new int[arr.length + 2][arr[0].length + 2];
        for(int c = 1, i = 0; i < arr.length; i++, c++) {
            for (int d = 1, j = 0; j < arr[i].length; j++, d++) {
                a[c][d] = arr[i][j];
            }
        }
        return a;
    }

    /**
     * 批量进行如下的操作：左上角(a, b) 右下角(c, d)范围上所有的数字 + v，应该如何快速处理
     * (a, b) += v
     * (a, d + 1) -= v
     * (c + 1, b) -= v
     * (c + 1, d + 1) += v
     *
     *     0   b   d   3   4
     *  0  0   0   0   0   0
     *  a  0   3   0   -3  0
     *  c  0   0   0   0   0
     *  3  0   -3  0   3   0
     *  4  0   0   0   0   0
     *
     * @param a 左上角 x
     * @param b 左上角 y
     * @param c 右下角 x
     * @param d 右下角 y
     * @param v 要加的数值
     */
    public static void add(int[][] diff, int a, int b, int c, int d, int v) {
        a += 1;
        b += 1;
        c += 1;
        d += 1;
        diff[a][b] += v;
        diff[a][d + 1] -= v;
        diff[c + 1][b] -= v;
        diff[c + 1][d + 1] += v;
    }

    /**
     * 形成前缀和数组
     *
     * @param matrix 原始数组
     */
    public static void buildPreArray(int[][] matrix) {
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] += matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
            }
        }
    }

    /**
     * 打印数组中的信息
     *
     * @param arr 原始数组
     */
    public static void print(int[][] arr) {
        for(int i = 1; i < arr.length - 1; i++) {
            for(int j = 1; j < arr[i].length - 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 打印扩充之后的原始数组
     *
     * @param arr
     */
    public static void printOrigin(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[4][5];
        // 扩充出来一圈的 0
        int[][] ints = changeArray(arr);
        printOrigin(ints);
        add(ints, 0, 0, 2, 3, 1);
        printOrigin(ints);
        buildPreArray(ints);
        printOrigin(ints);
    }
}