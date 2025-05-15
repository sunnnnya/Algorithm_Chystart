package job_interview.design_principle.liskov_substitution_principle.error;

/**
 * @BelongsPackage: job_interview.design_principle.liskov_substitution_principle
 * @ClassName: Square
 * @Author: 丛虹羽
 * @Date: 2025/5/15 22:28
 * @Description: 子类：正方形
 */
class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width); // 正方形强制宽高相等
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height); // 正方形强制宽高相等
    }
}
