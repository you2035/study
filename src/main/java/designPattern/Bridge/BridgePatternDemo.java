package designPattern.Bridge;

/**
 * @Auther: liuxin
 * @Date: 2020/1/3 16:16
 * @Description:
 */
public class BridgePatternDemo {
	public static void main(String[] args) {
		Shape redCircle = new Circle(100,100, 10, new RedCircle());
		Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

		redCircle.draw();
		greenCircle.draw();
	}
}
