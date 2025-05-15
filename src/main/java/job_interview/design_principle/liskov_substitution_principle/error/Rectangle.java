package job_interview.design_principle.liskov_substitution_principle.error;

/**
 * @BelongsPackage: job_interview.design_principle.liskov_substitution_principle
 * @ClassName: Rectangle
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:43
 * @Description: 矩形类 基类
 */
public class Rectangle {
    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return width * height;
    }
}
