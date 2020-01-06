package designPattern.DecoratorPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/6 15:29
 * @Description: 装饰器模式
 */
public class DecoratorPatternDemo {
	public static void main(String[] args) {

		Shape circle = new Circle();
		ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
		ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
		//Shape redCircle = new RedShapeDecorator(new Circle());
		//Shape redRectangle = new RedShapeDecorator(new Rectangle());
		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}
}