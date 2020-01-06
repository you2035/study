package designPattern.FacadePattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/6 16:04
 * @Description: 外观模式
 */
public class FacadePatternDemo {
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();

		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}
}
