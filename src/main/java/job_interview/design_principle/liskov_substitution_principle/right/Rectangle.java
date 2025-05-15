package job_interview.design_principle.liskov_substitution_principle.right;

/**
 * @BelongsPackage: job_interview.design_principle.liskov_substitution_principle.right
 * @ClassName: Rectangle
 * @Author: 丛虹羽
 * @Date: 2025/5/15 22:32
 * @Description: 矩形类
 */
class Rectangle implements Shape {
    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}