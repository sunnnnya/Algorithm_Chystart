package practice_questions.bit_operation.medium;

/**
 * @BelongsPackage: practice_questions.bit_operation.medium
 * @ClassName: TrainingPlan
 * @Author: 丛虹羽
 * @Date: 2024/8/12 下午9:53
 * @Description: 训练计划 VI
 *
 * 教学过程中，教练示范一次，学员跟做三次。该过程被混乱剪辑后，记录于数组 actions，其中 actions[i] 表示做出该动作的人员编号。请返回教练的编号。
 *
 * leetcode:https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 */
public class TrainingPlan {

    /**
     * 使用位运算进行状态压缩
     *
     * @param actions
     * @return
     */
    public static int trainingPlan(int[] actions) {
        int[] arr = new int[32];
        for (int number : actions) {
            for (int i = 0; i < 31; i++) {
                arr[i] += (number >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 表示 i 位上面的bit为1，1 << i
            if (arr[i] % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {5, 7, 5, 5};
        System.out.println(trainingPlan(arr));
        // 7

        int[] arr1 = {12, 1, 6, 12, 6, 12, 6};
        System.out.println(trainingPlan(arr1));
        // 1
    }
}
