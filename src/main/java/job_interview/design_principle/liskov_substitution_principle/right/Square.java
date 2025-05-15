package job_interview.design_principle.liskov_substitution_principle.right;

/**
 * @BelongsPackage: job_interview.design_principle.liskov_substitution_principle.right
 * @ClassName: Square
 * @Author: 丛虹羽
 * @Date: 2025/5/15 22:33
 * @Description: 正方形类
 */
class Square implements Shape {
    private int side;

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}